package com.jefersonm.apache.camel;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class CamelRouter extends RouteBuilder {

    @Override
    public void configure() {
        /*
           Route triggered each 2 seconds, executing customBean saySomething method to print to console
         */
        from("timer:hello?period={{timer.period}}").routeId("hello")
                .transform().method("customBean", "saySomething")
                .end()
                .to("stream:out");

    }

}
