package com.nonchaos.Tools;

import com.nonchaos.Demos.Dto3;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;

public class StringComp {
  public static void main(String[] args) {
    Dto3 dto3 = new Dto3();
    Object obj = toObject(dto3);

    Dto3 newDto3 = new Dto3();

//    BeanUtils.copyProperties(obj, newDto3);
    System.out.println(newDto3.toString());
  }

  public static Object toObject(Dto3 dto3) {
    dto3.setAge(11);
    dto3.setName("ll");
    List<Dto3> list = new ArrayList<>();
    list.add(dto3);
    return list;
  }

}
