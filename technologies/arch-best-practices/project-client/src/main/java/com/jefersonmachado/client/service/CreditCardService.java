package com.jefersonmachado.client.service;

//Dummy Service created to exemplify Hystrix functionality
public class CreditCardService {

    public void validate() throws RuntimeException {
        // Simulate some random errors to validate Circuit Breaker
        if (Math.random() > 0.998)
            throw new RuntimeException("Limited exceeded attemps");
    }

}
