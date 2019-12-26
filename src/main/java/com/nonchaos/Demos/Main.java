package com.nonchaos.Demos;

import com.alibaba.fastjson.JSONObject;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import com.alibaba.fastjson.JSON;

public class Main {
  public static void main(String[] args) {
    Dto1 dto1 = new Dto1();
//    String str = "{\n" + "        \"name\": \"haris\",\n" + "        \"sex\": \"male\",\n"
//        + "        \"age\": 18,\n" + "        \"birthday\": \"1576463312\"\n" + "    }";

    String str = "{\n" + "    \"dto1\": {\n" + "        \"name\": \"haris\",\n"
        + "        \"sex\": \"male\",\n" + "        \"age\": 18,\n"
        + "        \"birthday\": \"1576486764000\"\n" + "    }\n" + "}";
//    dto1 = JSON.parseObject(str, Dto1.class);
//    Object object = JSONObject.parseObject(str, Dto2.class);

    JSONObject jsonObject = JSON.parseObject(str);
    System.out.println(jsonObject.getObject("dto1", Dto1.class));
    Dto1 d2 = jsonObject.getObject("dto1", Dto1.class);
    Calendar calendar = Calendar.getInstance();
    calendar.setTime(d2.getBirthday());
    System.out.println(calendar.get(Calendar.YEAR) + " 年 " +
        (calendar.get(Calendar.MONTH) + 1) + " 月 " +
        calendar.get(Calendar.DATE) + " 日 ");

    Date date = new Date();
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    System.out.println(simpleDateFormat.format(date));  // 将Date数据格式化输出


    System.out.println(jsonObject.toString());  // 直接利用parseObject方法转换成的JSONObject输出其字符串形式
    System.out.println(calendar.getTime()); // 获取时间
  }
}
