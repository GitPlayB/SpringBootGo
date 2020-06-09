package com.nonchaos.Tools;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.nonchaos.Demos.Dto1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * FastJson循环引用导致{"$ref":"$[0]"}
 * 实际上这是fastjson为了防止StackOverFlow而做的一个特殊处理
 * 其实还是自己的代码有问题:)
 * 场景就是：fastjson把对象解析成一个字符串时，
 * 如果包含相同的对象（如List中包含相同的对象）；
 * 或者包含相互引用的对象（如两个Map相互引用）
 * fastjson就会用引用来表示它，而不是重新复制一份同样的对象
 */
public class FastJsonSameObject2Ref {
  public static void main(String[] args) {
    Map<String, Dto1> map = new HashMap<>();
    List<Dto1> dto1s = new ArrayList<>();
    List<Dto1> dto2s = new ArrayList<>();

    Dto1 dto1 = new Dto1("jay");
    for (int i = 0; i < 5; i++) {
      map.put("dto1", dto1);

      // 每次添加的dto1实际上是同一个对象，如果每次都new一个对象，fastjson也不会认为是同一个而使用引用了
      dto1s.add(map.get("dto1"));
    }


    for (int i = 0; i < 5; i++) {
      Dto1 dto2 = new Dto1("jay" + i);
      map.put("dto1", dto2);
      dto2s.add(map.get("dto1"));
      dto2s.add(map.get("dto1"));   // 添加相同对象
      // 正常情况下，不可能这么写。因为一个List里添加两个一模一样的对象没什么意义。此处只是为了复现问题
    }

    System.out.println("方式一：问题场景重现");
    dto1s.forEach(
        item -> System.out.println(item.toString())
    );

    String json = JSON.toJSONString(dto1s);
    System.out.println(json);
    System.out.println("方式一：问题场景重现-----结束\n");

    System.out.println("方式二：仅添加相同对象");
    dto2s.forEach(
        item -> System.out.println(item.toString())
    );

    String json2 = JSON.toJSONString(dto2s);
    System.out.println(json2);
    System.out.println("方式一：仅添加相同对象-----结束");


    // 加上取消循环引用，就可以转换多份相同的内容
//    String jsonWithoutReference = JSON.toJSONString(dto1s, SerializerFeature.DisableCircularReferenceDetect);
//    System.out.println(jsonWithoutReference);
  }
}
