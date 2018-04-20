package com.jefersonm.poc.quartz;

import com.jefersonm.poc.quartz.scheduler.AdminScheduler;
import com.jefersonm.poc.quartz.scheduler.BackupRestoreScheduler;
import com.jefersonm.poc.quartz.scheduler.HeartbeatScheduler;
import com.jefersonm.poc.quartz.scheduler.RecoveryScheduler;
import com.jefersonm.poc.quartz.tasks.*;
import org.quartz.JobDataMap;
import org.quartz.JobDetail;
import org.quartz.SchedulerException;
import org.quartz.Trigger;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import static org.quartz.JobBuilder.newJob;
import static org.quartz.SimpleScheduleBuilder.simpleSchedule;
import static org.quartz.TriggerBuilder.newTrigger;

public class Main {

    public static void main(String[] args) throws Exception {
        Map<String, String> parameters = new ConcurrentHashMap<>();
        parameters.put("clusterName", "ClusterOne");
        new Main().startClusterTasks(parameters);

        parameters.put("clusterName", "ClusterTwo");
        new Main().startClusterTasks(parameters);
    }

    public void startClusterTasks(Map<String, String> parameters) throws SchedulerException {
        String clusterName = parameters.get("clusterName");
        
        JobDetail startTask = newJob(StartTask.class)
                .setJobData(new JobDataMap(parameters))
                .withIdentity("start"+clusterName, "groupAdmin")
                .build();

        Trigger triggerStart = newTrigger()
                .withIdentity("triggerStart"+clusterName, "groupAdmin")
                .startNow()
                .withSchedule(simpleSchedule())
                .build();

        JobDetail stopTask = newJob(StopTask.class)
                .setJobData(new JobDataMap(parameters))
                .withIdentity("stop"+clusterName, "groupAdmin")
                .build();

        Trigger triggerStop = newTrigger()
                .withIdentity("triggerStop"+clusterName, "groupAdmin")
                .startNow()
                .withSchedule(simpleSchedule())
                .build();

        JobDetail heartbeatTask = newJob(HeartbeatTask.class)
                .setJobData(new JobDataMap(parameters))
                .withIdentity("heartbeat"+clusterName, "groupHeartbeat")
                .build();

        Trigger triggerHeartbeat = newTrigger()
                .withIdentity("triggerHeartbeat"+clusterName, "groupHeartbeat")
                .startNow()
                .withSchedule(simpleSchedule())
                .build();

        JobDetail recoveryTask = newJob(RecoveryTask.class)
                .setJobData(new JobDataMap(parameters))
                .withIdentity("recovery"+clusterName, "groupRecovery")
                .build();

        Trigger triggerRecovery = newTrigger()
                .withIdentity("triggerRecovery"+clusterName, "groupRecovery")
                .startNow()
                .withSchedule(simpleSchedule())
                .build();


        JobDetail backupRestoreTask = newJob(BackupTask.class)
                .setJobData(new JobDataMap(parameters))
                .withIdentity("backup"+clusterName, "groupBackupRestore")
                .build();

        Trigger triggerBackupRestore = newTrigger()
                .withIdentity("triggerBackupRestore"+clusterName, "groupBackupRestore")
                .startNow()
                .withSchedule(simpleSchedule())
                .build();

        new AdminScheduler(clusterName).schedule(startTask, triggerStart);
        new AdminScheduler(clusterName).schedule(stopTask, triggerStop);

        new HeartbeatScheduler(clusterName).schedule(heartbeatTask, triggerHeartbeat);

        new RecoveryScheduler(clusterName).schedule(recoveryTask, triggerRecovery);

        new BackupRestoreScheduler(clusterName).schedule(backupRestoreTask, triggerBackupRestore);
    }

}
