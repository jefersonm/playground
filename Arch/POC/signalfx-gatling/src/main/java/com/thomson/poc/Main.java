package com.thomson.poc;

import com.thomson.poc.atlas.PublishChart;
import com.thomson.poc.core.SignalFlowMetric;
import com.thomson.poc.pojo.MetricOutput;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class Main {

    public static void main(String[] args) throws Exception {
        SignalFlowMetric metricService = new SignalFlowMetric();
        PublishChart publishChart = new PublishChart();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime start = LocalDateTime.parse("2016-11-04 15:20:50", formatter);
        LocalDateTime end = LocalDateTime.parse("2016-11-04 15:22:50", formatter);

        String signalfxData = "data('memory.free', filter('aws_region','us-west-2')).top(5).publish()";
        List<MetricOutput> metrics = metricService.getMetrics(signalfxData, start, end);

        publishChart.publish(metrics);
        publishChart.exportToPng();
    }

}
