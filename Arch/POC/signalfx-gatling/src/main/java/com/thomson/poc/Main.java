package com.thomson.poc;

import com.thomson.poc.core.SignalFlowMetric;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Main {

    public static void main(String[] args) throws Exception {
        SignalFlowMetric metricService = new SignalFlowMetric();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        LocalDateTime start = LocalDateTime.parse("2016-11-04 16:08:50", formatter);
        LocalDateTime end = LocalDateTime.parse("2016-11-04 16:13:50", formatter);
        String signalfxData = "data('memory.free', filter('aws_region','us-west-2')).top(5).publish()";

        metricService.generateChart(signalfxData, start, end);
    }

}
