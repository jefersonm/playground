package com.jefersonm.cloudnative.timeout;

import java.time.Duration;
import java.util.concurrent.*;
import com.jefersonm.cloudnative.exception.TimeoutException;

public class TimeoutCommand {

    private static final ExecutorService executor = Executors.newSingleThreadExecutor();

    public static void executeWithTimeout(int timeoutInMilliseconds, Runnable fn) {
        final Duration timeout = Duration.ofMillis(timeoutInMilliseconds);
        final Future<?> future = executor.submit(fn);

        try {
            future.get(timeout.toMillis(), TimeUnit.MILLISECONDS);
        } catch (Exception error) {
            future.cancel(true);
            throw new TimeoutException(String.format("Method could not run within the specified timeout: %s milliseconds", timeoutInMilliseconds));
        }
    }

}
