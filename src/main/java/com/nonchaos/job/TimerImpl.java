package com.nonchaos.job;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class TimerImpl {
  public static void main(String[] args) {
//    // 延迟delay毫秒执行
//    for (int i = 0; i < 10; ++i) {
//      new Timer("timer - " + i).schedule(new TimerTask() {
//        @Override
//        public void run() {
//          System.out.println(Thread.currentThread().getName() + " run ");
//        }
//      }, 1000);
//    }
//
//    // 特定时间执行
//    for (int i = 0; i < 10; ++i) {
//      new Timer("timer - " + i).schedule(new TimerTask() {
//        @Override
//        public void run() {
//          System.out.println(Thread.currentThread().getName() + " run ");
//        }
//      }, new Date(System.currentTimeMillis() + 2000));
//    }
//
    // 延迟delay执行并每隔period执行一次
    for (int i = 0; i < 3; ++i) {
      new Timer("timer - " + i).schedule(new TimerTask() {
        @Override
        public void run() {
          System.out.println(Thread.currentThread().getName() + " run at " + new Date());
        }
      }, 2000 , 5000);
    }

    // ScheduledExecutorService接口实现类
//    ScheduledThreadPoolExecutor executor = (ScheduledThreadPoolExecutor)Executors.newScheduledThreadPool(10);
//    for (int i = 0; i < 10; i++) {
//      executor.schedule(new Runnable() {
//        @Override public void run() {
//          System.out.println(Thread.currentThread().getName() + " run ");
//        }
//      }, 2, TimeUnit.SECONDS);
//    }
//    executor.shutdown();


  }
}
