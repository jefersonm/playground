package com.thomson.poc.pojo;


import java.io.Serializable;
import java.util.List;

public class MetricOutput implements Serializable {

    private Tags tags;
    private List<MetricHost> metrics;

    public Tags getTags() {
        return tags;
    }

    public void setTags(Tags tags) {
        this.tags = tags;
    }

    public List<MetricHost> getMetrics() {
        return metrics;
    }

    public void setMetrics(List<MetricHost> metrics) {
        this.metrics = metrics;
    }
}
