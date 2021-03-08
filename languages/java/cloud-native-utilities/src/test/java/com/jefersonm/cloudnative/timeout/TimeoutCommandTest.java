package com.jefersonm.cloudnative.timeout;

import com.jefersonm.cloudnative.exception.TimeoutException;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TimeoutCommandTest {

    private static Logger logger = LoggerFactory.getLogger(TimeoutCommandTest.class);

    @Test
    public void testCommandThatRunsWithimTheTimeout() {
        int millisecondTimeout = 1000 * 10;
        TimeoutCommand.executeWithTimeout(millisecondTimeout, this::executeCommandWithEnoughTimeout);
    }

    @Test(expected = TimeoutException.class)
    public void testCommandThatTakesTooMuchTimeToRun() {
        int millisecondTimeout = 1000 * 10;
        TimeoutCommand.executeWithTimeout(millisecondTimeout, this::executeCommandWithNotEnoughTimeout);
    }

    private void executeCommandWithNotEnoughTimeout() {
        int millisecondTimeout = 1000 * 20;
        executeCommand(millisecondTimeout);
    }

    private void executeCommandWithEnoughTimeout() {
        int millisecondTimeout = 1000 * 5;
        executeCommand(millisecondTimeout);
    }

    private void executeCommand(int millisecondTimeout) {
        logger.info("Executing fake command and throwing an error");
        try {
            Thread.sleep(millisecondTimeout);
        } catch (InterruptedException e) {
            logger.error("Command could not run within specified timeout");
        }
        logger.info("Command run successfully");
    }

}
