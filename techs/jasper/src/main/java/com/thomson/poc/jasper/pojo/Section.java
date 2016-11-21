package com.thomson.poc.jasper.pojo;

import java.util.List;

public class Section {

    private String type;
    private List<Metric> metrics;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<Metric> getMetrics() {
        return metrics;
    }

    public void setMetrics(List<Metric> metrics) {
        this.metrics = metrics;
    }
}
