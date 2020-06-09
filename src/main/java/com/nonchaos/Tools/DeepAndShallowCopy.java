package com.nonchaos.Tools;

import com.nonchaos.Demos.Dto1;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * 深浅拷贝：单个对象和List<>对象
 * 当某个方法返回一个List时，返回的其实是这个List的引用
 * 所以，一般情况下，是要把它的元素遍历一遍然后add进来的（或者addAll）
 * 在方法内部直接赋值通常是不可用的
 */
public class DeepAndShallowCopy {
  public static void main(String[] args) {
    Dto1 dto111 = new Dto1();
    dto111.setSex("male");
    dto111.setName("john");
    dto111.setAge(18);
    Dto1 dto112 = new Dto1();
    dto112.setSex("female");
    dto112.setName("lora");
    dto112.setAge(22);
    List<Dto1> dto11s = new ArrayList<>();
    dto11s.add(dto111);
    dto11s.add(dto112);

    List<Dto1> dto22s = new ArrayList<>();
    //    dto22s = dto11s;    // 直接将List引用赋值，改变指向也可以获得对应指向的内容
    DeepAndShallowCopy.copyDto1s(dto11s, dto22s);
    System.out.println(dto11s.hashCode());
    System.out.println(dto22s.hashCode());
    dto22s.forEach(
        item -> System.out.println(item.toString())
    );

    Dto1 dto222 = new Dto1();
    DeepAndShallowCopy.copyDto1(dto111, dto222);
    System.out.println(dto222.toString());
    DeepAndShallowCopy.deepCopyDto1(dto111, dto222);
    System.out.println(dto222.toString());
  }

  /**
   * 方式一：直接将两个List类型引用赋值，无效
   * IDEA也会有提示，灰色的字体并且放上去会有tooltips
   */
  public static void copyDto1(Dto1 dto1, Dto1 dto2) {
    dto2 = dto1;
  }

  /**
   * 方式二：拷贝每个字段，有效
   */
  public static void deepCopyDto1(Dto1 dto1, Dto1 dto2) {
    BeanUtils.copyProperties(dto1, dto2);
  }

  /**
   * 拷贝List：通过遍历List内容将其add到要赋值的List上，有效
   */
  public static void copyDto1s(List<Dto1> dto1s, List<Dto1> dto2s) {

    // 同样无法直接赋值
//    dto2s = dto1s;

    List<Dto1> tmp = new ArrayList<>();
    dto1s.forEach(
        item -> {
          Dto1 dto2 = new Dto1();
          BeanUtils.copyProperties(item, dto2);
          tmp.add(dto2);
        }
    );
    dto2s = tmp;

//    dto1s.forEach(
//        item -> {
//          Dto1 dto2 = new Dto1();
//          BeanUtils.copyProperties(item, dto2);
//          dto2s.add(dto2);
//        }
//    );
//    System.out.println(dto1s.hashCode());
//    System.out.println(dto2s.hashCode());
  }
}
