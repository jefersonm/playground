package com.jefersonm.poc.quartz.scheduler;

import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.impl.StdSchedulerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.util.Properties;

public class BackupRestoreScheduler {

    private static final Logger logger = LoggerFactory.getLogger(BackupRestoreScheduler.class);
    private static Scheduler scheduler;

    public BackupRestoreScheduler(String clusterName) {
        init(clusterName);
    }

    public static void init(String clusterName) {
        try {
            String instanceName = "BackupRestoreScheduler_"+clusterName;
            if(scheduler != null && instanceName.equals(scheduler.getMetaData().getSchedulerName()))
                return;

            Properties properties = new Properties();
            properties.put("org.quartz.scheduler.instanceName", instanceName);
            properties.put("org.quartz.threadPool.threadCount", "1");
            properties.put("org.quartz.jobStore.class", "org.quartz.simpl.RAMJobStore");
            scheduler = new StdSchedulerFactory(properties).getScheduler();
            scheduler.start();
        } catch (Exception error) {
            logger.error("Error trying to start Backup Restore Quartz Scheduler. Error message: ", error);
        }

    }


    public void schedule(JobDetail job, Trigger trigger) throws SchedulerException {
        scheduler.scheduleJob(job, trigger);
    }

}
