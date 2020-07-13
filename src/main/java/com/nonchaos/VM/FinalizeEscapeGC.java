package com.nonchaos.VM;

/**
 * 1.对象可以在被GC时自我拯救
 * 2.自救机会只有一次，因为一个对象的finalize()方法最多被系统自动调用一次
 */
public class FinalizeEscapeGC {
  public static FinalizeEscapeGC SAVE_HOOK = null;    // 注意：是public！
  public void isAlive() {
    System.out.println("Yes, I'm still alive :)");
  }

  @Override
  protected void finalize() throws Throwable {
    super.finalize();
    System.out.println("finalize() method executed!");
    FinalizeEscapeGC.SAVE_HOOK = this;
  }

  public static void main(String[] args) throws Throwable {
    SAVE_HOOK = new FinalizeEscapeGC();

    SAVE_HOOK = null;
    System.gc();
    Thread.sleep(500);
    if (SAVE_HOOK != null) {
      SAVE_HOOK.isAlive();
    } else {
      System.out.println("No, I' am dead :(");
    }

    /**
     * 第二次自我拯救
     */
    SAVE_HOOK = null;
    System.gc();
    Thread.sleep(500);
    if (SAVE_HOOK != null) {
      SAVE_HOOK.isAlive();
    } else {
      System.out.println("No, I' am dead :(");
    }
  }
}
