package com.jefersonm.cloudnative.retry;

import com.jefersonm.cloudnative.exception.RemoteCallException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.function.Supplier;

public class RetryCommand {

    private static Logger logger = LoggerFactory.getLogger(RetryCommand.class);

    private static final int[] INCREMENTAL_WAITING_TIME = new int[] {1, 2, 3};
    private static final int RETRY_COUNT = INCREMENTAL_WAITING_TIME.length;

    private RetryCommand() {}

    public static <T> T execute(Supplier<T> fn) {
        for (int attempt = 0; attempt < RETRY_COUNT; attempt++) {
            try {
                return fn.get();
            } catch (Exception error) {
                logger.info(String.format("Command has failed, trying again. Attempt number: %s.", attempt));
                doWait(attempt);
            }
        }
        String errorMsg = String.format("Failed to execute command from class: %s.", fn.getClass());
        logger.error(errorMsg);
        throw new RemoteCallException(errorMsg);
    }

    private static void doWait(int attempt) {
        try {
            Thread.sleep(INCREMENTAL_WAITING_TIME[attempt] * 1000);
        } catch (InterruptedException error) {
            throw new RuntimeException(error);
        }
    }

}
