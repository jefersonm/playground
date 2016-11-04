package com.thomson.poc.atlas;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "atlas")
public class AtlasConfig {

    private String api;
    private String output;

    String getPublishApi() {
        return String.format("%s/publish", this.api);
    }

    String getGraphApi() {
        return String.format("%s/graph", this.api);
    }

    String getOutput() {
        return output;
    }

    public void setOutput(String output) {
        this.output = output;
    }

    public String getApi() {
        return api;
    }

    public void setApi(String api) {
        this.api = api;
    }
}
