package com.nonchaos.VM;

import java.util.ArrayList;
import java.util.List;

/**
 * 测试堆内存异常OutOfMemoryError
 * VM Args:
 * -Xms20m
 * -Xmx20m
 * -XX:+HeapDumpOnOutOfMemoryError
 * @author oliv
 */
public class HeapOOM {
  static class OOMObject{
  }

  public static void main(String[] args) {
    List<OOMObject> list = new ArrayList<>();
    while (true) {
      list.add(new OOMObject());
    }
  }
}
