package com.jefersonm.poc.quartz;

import com.jefersonm.poc.quartz.scheduler.AdminScheduler;
import com.jefersonm.poc.quartz.scheduler.HeartbeatScheduler;

public class Main {

    public static void main(String[] args) throws Exception {
        new AdminScheduler().schedule();
        new HeartbeatScheduler().schedule();
    }

}
