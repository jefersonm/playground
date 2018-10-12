package com.jefersonm.apache.camel;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("customBean")
public class CustomBean {

    @Value("${greeting}")
    private String say;

    public String saySomething() {
        return say;
    }

}