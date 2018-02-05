package com.thomson.poc.jasper.pojo;

import java.util.List;

public class Report {

    private String serviceName;
    private List<Section> sections;

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public List<Section> getSections() {
        return sections;
    }

    public void setSections(List<Section> sections) {
        this.sections = sections;
    }
}
