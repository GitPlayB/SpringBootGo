package com.nonchaos.VM;

/**
 * Java虚拟机栈栈溢出测试
 * VM Args: -Xss128k
 * @author oliv
 */
public class JavaVMStackSOF {
  private int stackLength = 1;
  public void stackLeak() {
    stackLength++;
    stackLeak();
  }

  public static void main(String[] args) {
    JavaVMStackSOF oom = new JavaVMStackSOF();
    try {
      oom.stackLeak();
    } catch (Throwable e) {
      System.out.println("stack length: " + oom.stackLength);
      throw e;
    }
  }
}
