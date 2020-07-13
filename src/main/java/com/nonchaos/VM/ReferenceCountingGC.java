package com.nonchaos.VM;

/**
 * 引用计数垃圾回收
 * 参数：-XX:+PrintGCDetails
 *
 */
public class ReferenceCountingGC {
  public Object instace = null;
  private static final int _1MB = 1024 * 1024;    // 占内存用的，以便在GC日志中看到是否被回收过
  private  byte[] bigSize = new byte[2 *_1MB];

  public static void testGC() {
    ReferenceCountingGC objA = new ReferenceCountingGC();
    ReferenceCountingGC objB = new ReferenceCountingGC();
    objA.instace = objB;
    objB.instace = objA;
    objA = null;
    objB = null;
    System.gc();
  }

  public static void main(String[] args) {
    ReferenceCountingGC.testGC();
  }
}
