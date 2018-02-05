package com.thomson.poc.jasper.pojo;

import java.io.InputStream;

public class Metric {

    private String name;
    private InputStream image;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public InputStream getImage() {
        return image;
    }

    public void setImage(InputStream image) {
        this.image = image;
    }
}
