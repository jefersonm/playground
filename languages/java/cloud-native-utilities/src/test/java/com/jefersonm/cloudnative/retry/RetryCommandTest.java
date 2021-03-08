package com.jefersonm.cloudnative.retry;

import com.jefersonm.cloudnative.exception.RemoteCallException;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.web.client.RestTemplate;


public class RetryCommandTest {

    private RestTemplate restTemplate = new RestTemplate();

    @Test
    public void testSuccessfulRemoteCommand() {
        RetryCommand.execute(() -> {
            String result = restTemplate.getForObject("https://jsonplaceholder.typicode.com/todos/1", String.class);
            Assert.assertNotNull(result);
            return result;
        });
    }

    @Test(expected = RemoteCallException.class)
    public void testFailedRemoteCommand() {
        RetryCommand.execute(() -> {
            String result = restTemplate.getForObject("https://jsonplaceholder.typicode.cm/todos/1", String.class);
            Assert.assertNotNull(result);
            return result;
        });
    }

}
