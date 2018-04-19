package com.jefersonm.poc.quartz.scheduler;

import static org.quartz.JobBuilder.newJob;
import static org.quartz.SimpleScheduleBuilder.simpleSchedule;
import static org.quartz.TriggerBuilder.newTrigger;

import com.jefersonm.poc.quartz.tasks.HeartbeatTask;
import com.jefersonm.poc.quartz.tasks.StartTask;
import com.jefersonm.poc.quartz.tasks.StopTask;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.impl.StdSchedulerFactory;

public class AdminScheduler {

    public void schedule() throws SchedulerException {

        Scheduler adminScheduler = new StdSchedulerFactory(AdminScheduler.class.getClassLoader().getResource("quartz-admin.properties").getFile()).getScheduler();
        System.out.println("Admin Scheduler: " + adminScheduler.getSchedulerName());
        adminScheduler.start();

        JobDetail startJob = newJob(StartTask.class)
                .withIdentity("start", "adminGroup")
                .build();

        JobDetail stopJob = newJob(StopTask.class)
                .withIdentity("stop", "adminGroup")
                .build();

        Trigger triggerStart = newTrigger()
                .withIdentity("adminGroup", "adminGroup")
                .startNow()
                .withSchedule(simpleSchedule()
                        .withIntervalInSeconds(5)
                        .repeatForever())
                .build();

        Trigger triggerStop = newTrigger()
                .withIdentity("triggerStop", "adminGroup")
                .startNow()
                .withSchedule(simpleSchedule()
                        .withIntervalInSeconds(5)
                        .repeatForever())
                .build();


        adminScheduler.scheduleJob(startJob, triggerStart);
        adminScheduler.scheduleJob(stopJob, triggerStop);
    }

}
