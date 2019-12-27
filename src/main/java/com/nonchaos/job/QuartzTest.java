package com.nonchaos.job;

import org.quartz.Job;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.impl.StdSchedulerFactory;

public class QuartzTest {
  public static void main(String[] args) {
    try {
      Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
      scheduler.start();



      scheduler.shutdown();
    } catch (SchedulerException e) {
      e.getMessage();
    }
  }
}
