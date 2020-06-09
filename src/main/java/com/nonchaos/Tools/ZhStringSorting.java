package com.nonchaos.Tools;

import com.nonchaos.Demos.Dto1;

import java.text.Collator;
import java.util.*;
import java.util.stream.Collectors;

/**
 * 中文名称（字符串）排序
 * 使用Stream API配合Collator实现
 * Collator里设置locale为CHINA即可按拼音排序
 */
public class ZhStringSorting {
  public static void main(String[] args) {
    List<String> strings = new ArrayList<>();
    strings.add("恒大山水城");
    strings.add("中恒大山水城");
    strings.add("南恒大山水城");
    strings.add("四恒大山水城");
    strings.add("川恒大山水城");
    sortListString(strings);
    strings.forEach(
        item -> System.out.println(item)
    );

    List<Dto1> dto1List = new ArrayList<>();
    Dto1 d1 = new Dto1();
    d1.setName("恒大山水城");
    Dto1 d2 = new Dto1();
    d2.setName("中恒大山水城");
    Dto1 d3 = new Dto1();
    d3.setName("南恒大山水城");
    Dto1 d4 = new Dto1();
    d4.setName("四恒大山水城");
    Dto1 d5 = new Dto1();
    d5.setName("川恒大山水城");
    dto1List.addAll(Arrays.asList(d1, d2, d3, d4, d5));
    sortListObj(dto1List);
    for (Dto1 dto1 : dto1List) {
      System.out.println(dto1);
    }

    Comparator cmp = Collator.getInstance(java.util.Locale.CHINA);
//    dto1List = dto1List.stream()
//        .sorted(Comparator.comparing(Dto1::getName, cmp))
//        .collect(Collectors.toList());
    dto1List = dto1List.stream()
        .sorted(Comparator.comparing(Dto1::getName, Collator.getInstance(java.util.Locale.CHINA)))
        .collect(Collectors.toList());
    for (Dto1 dto1 : dto1List) {
      System.out.println(dto1);
    }
  }

  public static void sortListObj(List<Dto1> args) {
    Collections.sort(args, new Comparator<Dto1>() {
      @Override public int compare(Dto1 o1, Dto1 o2) {
        return o1.getName().compareTo(o2.getName());
      }
    });
  }

  public static void sortListString(List<String> args) {
    Comparator cmp = Collator.getInstance(java.util.Locale.CHINA);
    Collections.sort(args, cmp);
  }
}
