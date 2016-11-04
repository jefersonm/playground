package com.thomson.poc.core;

import com.signalfx.signalflow.ChannelMessage;
import com.signalfx.signalflow.Computation;
import com.signalfx.signalflow.SignalFlowClient;
import com.thomson.poc.atlas.AtlasChart;
import com.thomson.poc.pojo.MetricHost;
import com.thomson.poc.pojo.MetricOutput;
import com.thomson.poc.pojo.Tags;
import com.thomson.poc.signalfx.SignalFlowCustomConnection;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class SignalFlowMetric {

    @Autowired
    private AtlasChart atlasChart;
    private final Logger log = Logger.getLogger(SignalFlowMetric.class);

    public Boolean generateChart(String signalfxData, LocalDateTime start, LocalDateTime end) {
        try {
            List<MetricOutput> metrics = getMetrics(signalfxData, start, end);
            atlasChart.publish(metrics);
            atlasChart.exportToPng();
            return true;
        } catch (Exception e) {
            log.error("Error generating chart: " + e.getMessage());
            return false;
        }
    }

    public List<MetricOutput> getMetrics(String signalfxData, LocalDateTime start, LocalDateTime end) {
        String token = System.getProperty("signalfxToken");
        SignalFlowCustomConnection connection = new SignalFlowCustomConnection(token);
        SignalFlowClient flow = new SignalFlowClient(connection.getCustomConnection());
        List<MetricOutput> metrics = new ArrayList<>();
        try {
            Computation computation = flow.execute(signalfxData, convertToTimestampMiliseconds(start), convertToTimestampMiliseconds(end), null, null, null);
            for (ChannelMessage message : computation) {
                switch (message.getType()) {
                    case DATA_MESSAGE:
                        metrics.add(buildMetricOutput(computation, (ChannelMessage.DataMessage) message));
                        break;
                }
            }
        } catch (Exception e) {
            log.error("Error trying to get message from SignalFx: " + e.getMessage());
        } finally {
            flow.close();
        }

        return metrics;
    }

    private MetricOutput buildMetricOutput(Computation computation, ChannelMessage.DataMessage dataMessage) {
        List<MetricHost> metricHosts = new ArrayList<>();
        MetricOutput metricOutput = new MetricOutput();
        metricHosts.addAll(dataMessage.getData().
                stream().map(data -> buildMetriHost(computation, data, dataMessage.getLogicalTimestampMs())).collect(Collectors.toList()));

        Tags tag = new Tags();
        tag.setMetric(getMetricName(computation, dataMessage.getData().get(0)));
        metricOutput.setMetrics(metricHosts);
        metricOutput.setTags(tag);
        return metricOutput;
    }

    private String getMetricName(Computation computation, Map<String, Object> data) {
        String tsId = formatTsId((String) data.get("tsId"));
        return (String)computation.getMetadata(tsId).get("sf_originatingMetric");
    }

    private MetricHost buildMetriHost(Computation computation, Map<String, Object> data, Long timestamp) {
        String tsId = formatTsId((String) data.get("tsId"));
        Map<String, Object> metadata = computation.getMetadata(tsId);
        Tags tag = new Tags();
        tag.setName((String) metadata.get("host"));
        return new MetricHost(tag, timestamp, (String) metadata.get("plugin"), (String) metadata.get("app"), (String) metadata.get("host"), (Double) data.get("value"));
    }

    private String formatTsId(String tsId){
        return tsId.replace("+","-").replace("//","__");
    }

    private Long convertToTimestampMiliseconds(LocalDateTime date) {
        return date.atZone(ZoneId.systemDefault()).toInstant().getEpochSecond() * 1000;
    }

}
