package com.thomson.poc.entrypoint;

import com.thomson.poc.core.SignalFlowMetric;
import com.thomson.poc.pojo.MetricOutput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Controller
@RequestMapping(value="/signalfx/v1")
public class MetricEntrypoint {

    @Autowired
    private SignalFlowMetric signalFlowMetric;

    @RequestMapping(value="/metric", method = RequestMethod.GET)
    public @ResponseBody List<MetricOutput> metric(@RequestParam String data, @RequestParam String startDate, @RequestParam String endDate) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime start = LocalDateTime.parse(startDate, formatter);
        LocalDateTime end = LocalDateTime.parse(endDate, formatter);
        List<MetricOutput> metrics = signalFlowMetric.getMetrics(data, start, end);
        return metrics;
    }

}
