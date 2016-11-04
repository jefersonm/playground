package com.thomson.poc.entrypoint;

import com.thomson.poc.core.SignalFlowMetric;
import com.thomson.poc.pojo.MetricOutput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
@RequestMapping(value="/signalfx/v1")
public class MetricEntrypoint {

    @Autowired
    private SignalFlowMetric signalFlowMetric;
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    @RequestMapping(value="/metric", method = RequestMethod.GET)
    public @ResponseBody List<MetricOutput> metric(@RequestParam String data, @RequestParam String startDate, @RequestParam String endDate) {
        LocalDateTime start = LocalDateTime.parse(startDate, formatter);
        LocalDateTime end = LocalDateTime.parse(endDate, formatter);
        return signalFlowMetric.getMetrics(data, start, end);
    }

    @RequestMapping(value="/chart", method = RequestMethod.GET)
    public @ResponseBody String chart(@RequestParam String data, @RequestParam String startDate, @RequestParam String endDate) {
        LocalDateTime start = LocalDateTime.parse(startDate, formatter);
        LocalDateTime end = LocalDateTime.parse(endDate, formatter);
        return signalFlowMetric.generateChart(data, start, end)==Boolean.TRUE?"Chart generated succefully":"Error generating chart";
    }

}
