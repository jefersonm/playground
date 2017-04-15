package com.jefersonmachado.client;


import com.jefersonmachado.client.model.Validation;
import com.jefersonmachado.client.service.CreditCardService;
import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class CreditCardClient extends HystrixCommand<Validation> {

    private Logger log = LoggerFactory.getLogger(CreditCardClient.class);

    protected CreditCardClient() {
        super(Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey("creditCard")));
    }

    @Override
    protected Validation run() throws InterruptedException {
        new CreditCardService().validate();
        return new Validation("Transaction completed successful");
    }

    @Override
    protected Validation getFallback() {
        try {
            log.debug("Waiting 10 seconds to try again");
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            log.debug("error: " + e.getMessage());
        }

        return new Validation("Transaction could not be completed, please try again after some time or call to your Bank");
    }

}
