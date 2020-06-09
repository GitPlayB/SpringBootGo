package com.nonchaos.Tools;

/**
 * String工具类
 */
public class StringUtil {
  private static final String CHARACTER_SET = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";

  public static void main(String[] args) {
    /** 进行多个字符串拼接时StringBuilder效率比String+高很多 */
    String s1 = "";
    Long before1 = System.currentTimeMillis();
    for (int i = 0; i < 3000; i++) {
      s1 += randomStringGenerator(5, 60);
    }
    Long after1 = System.currentTimeMillis();
    System.out.println("[String] time elapsed: " + (after1 - before1));
    System.out.println(s1);

    StringBuilder sb = new StringBuilder();
    Long before2 = System.currentTimeMillis();
    for (int i = 0; i < 3000; i++) {
      sb.append(randomStringGenerator(5, 60));
    }
    Long after2 = System.currentTimeMillis();
    System.out.println("[StringBuilder] time elapsed: " + (after2 - before2));
    System.out.println(sb);
    System.out.println(sb.toString());

  }

  /**
   * 产生一个长度为length的随机字符串
   * @param length 长度
   * @param randomSeed 随机种子
   * @return 生成的字符串
   */
  public static String randomStringGenerator(int length, int randomSeed) {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < length; i++) {
      sb.append(CHARACTER_SET.charAt((int)(Math.random() * randomSeed)));
    }
    return sb.toString();
  }
}
