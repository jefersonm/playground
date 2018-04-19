package com.jefersonm.poc.quartz.scheduler;

import com.jefersonm.poc.quartz.tasks.HeartbeatTask;
import com.jefersonm.poc.quartz.tasks.StartTask;
import com.jefersonm.poc.quartz.tasks.StopTask;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.impl.StdSchedulerFactory;

import static org.quartz.JobBuilder.newJob;
import static org.quartz.SimpleScheduleBuilder.simpleSchedule;
import static org.quartz.TriggerBuilder.newTrigger;

public class HeartbeatScheduler {

    public void schedule() throws SchedulerException {

        Scheduler heartbeatScheduler = new StdSchedulerFactory(AdminScheduler.class.getClassLoader().getResource("quartz-heartbeat.properties").getFile()).getScheduler();
        System.out.println("Admin Scheduler: " + heartbeatScheduler.getSchedulerName());
        heartbeatScheduler.start();

        JobDetail heartbeatJob = newJob(HeartbeatTask.class)
                .withIdentity("heartbeat", "heartbeatGroup")
                .build();

        Trigger triggerHeartbeat = newTrigger()
                .forJob(heartbeatJob)
                .withIdentity("heartbeat", "heartbeatGroup")
                .startNow()
                .withSchedule(simpleSchedule()
                        .withIntervalInSeconds(5)
                        .repeatForever())
                .build();

        heartbeatScheduler.scheduleJob(heartbeatJob, triggerHeartbeat);

    }

}
