package com.thomson.poc.pojo;

import java.io.Serializable;

public class MetricHost implements Serializable {

    private Tags tags;
    private Long timestamp;
    private String type;
    private String app;
    private String hostName;
    private Double value;

    public MetricHost(Tags tags, Long timestamp, String type, String app, String hostName, Double value) {
        this.tags = tags;
        this.timestamp = timestamp;
        this.type = type;
        this.app = app;
        this.hostName = hostName;
        this.value = value;
    }

    public Tags getTags() {
        return tags;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public String getType() {
        return type;
    }

    public String getApp() {
        return app;
    }

    public String getHostName() {
        return hostName;
    }

    public Double getValue() {
        return value;
    }
}
