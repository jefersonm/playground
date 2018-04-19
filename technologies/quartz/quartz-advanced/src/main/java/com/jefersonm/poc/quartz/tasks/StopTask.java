package com.jefersonm.poc.quartz.tasks;

import com.jefersonm.poc.quartz.DateTimeUtils;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class StopTask implements Job {

    public StopTask() {}

    public void execute(JobExecutionContext context) throws JobExecutionException {
        System.err.println("2 - Stop task is executing. "  + DateTimeUtils.getCurrentTimeStamp());
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
