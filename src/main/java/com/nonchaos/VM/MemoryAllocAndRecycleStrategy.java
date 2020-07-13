package com.nonchaos.VM;

/**
 * 測試不同的垃圾收集策略
 * VM参数：
 * -verbose:gc
 * -Xms20M
 * -Xmx20M
 * -Xmn10M
 * -XX:+PrintGCDetails
 */
public class MemoryAllocAndRecycleStrategy {
  private static final int _1MB = 1024 * 1024;

  public static void main(String[] args) {

  }

  /**
   * 测试发生在新生代的垃圾收集动作
   */
  public static void testAllocation() {
    byte[] allocation1, allocation2, allocation3, allocation4;
    allocation1 = new byte[2*_1MB];
    allocation2 = new byte[2*_1MB];
    allocation3 = new byte[2*_1MB];
    allocation4 = new byte[4*_1MB];   // 出现一次Minor GC
  }
}
