package com.jefersonm.poc.quartz.tasks;

import com.jefersonm.poc.quartz.DateTimeUtils;
import org.quartz.Job;
import org.quartz.JobExecutionContext;

public class StopTask implements Job {

    public StopTask() {}

    public void execute(JobExecutionContext context) {
        String clusterName = (String) context.getJobDetail().getJobDataMap().get("clusterName");
        System.out.println("{ADMIN} Stop task is executing. "  + DateTimeUtils.getCurrentTimeStamp() + " Cluster name: " + clusterName);
        try {
            Thread.sleep(5000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
