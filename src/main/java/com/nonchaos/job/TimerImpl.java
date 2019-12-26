package com.nonchaos.job;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class TimerImpl {
  public static void main(String[] args) {
//    for (int i = 0; i < 10; ++i) {
//      new Timer("timer - " + i).schedule(new TimerTask() {
//        @Override
//        public void run() {
//          System.out.println(Thread.currentThread().getName() + " run ");
//        }
//      }, 1000);
//    }

//    for (int i = 0; i < 10; ++i) {
//      new Timer("timer - " + i).schedule(new TimerTask() {
//        @Override
//        public void run() {
//          System.out.println(Thread.currentThread().getName() + " run ");
//        }
//      }, new Date(System.currentTimeMillis() + 2000));
//    }

    for (int i = 0; i < 3; ++i) {
      new Timer("timer - " + i).schedule(new TimerTask() {
        @Override
        public void run() {
          System.out.println(Thread.currentThread().getName() + " run ");
        }
      }, 2000 , 5000);
    }

  }
}
