package com.nonchaos.VM;

import java.util.ArrayList;
import java.util.List;

/**
 * 测试运行时常量池内存溢出异常
 * 这个也不要轻易运行，容易卡死
 * VM Args：
 * -XX:PermSize=10M
 * -XX:MaxPermSize=10M
 */
public class RuntimeConstantPoolOOM {
  public static void main(String[] args) {
    //    List<String> list = new ArrayList<>();
    //    int i = 0;
    //    while (true) {
    //      list.add(String.valueOf(i++).intern());
    //    }

    testPublicConstantPool();
  }

  public static void testPublicConstantPool() {
    String str1 = new StringBuilder("计算机").append("软件").toString();
    System.out.println(str1.intern() == str1);
    String str2 = new StringBuilder("Ja").append("va").toString();
    String str3 = str2.intern();
    System.out.println(str3 == str2);
  }
}
