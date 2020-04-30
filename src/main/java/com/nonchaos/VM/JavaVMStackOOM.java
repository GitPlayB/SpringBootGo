package com.nonchaos.VM;

/**
 * 测试创建线程导致内存溢出
 * 不要轻易运行这个，很有可能导致计算机卡死需重启
 * 或者运行前保存好工作内容
 * VM ArgsL -Xss2M
 * @author oliv
 */
public class JavaVMStackOOM {
  private void dontStop() {
    while (true) {
    }
  }

  public void stackLeakByThread() {
    while (true) {
      Thread thread = new Thread(new Runnable() {
        @Override public void run() {
          dontStop();
        }
      });
      thread.start();
    }
  }

  public static void main(String[] args) {
    JavaVMStackOOM oom = new JavaVMStackOOM();
    oom.stackLeakByThread();
  }
}
