package com.nonchaos.Demos;

import com.alibaba.fastjson.JSONObject;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;
import java.util.UUID;

import com.alibaba.fastjson.JSON;

public class Main {
  public static void main(String[] args) {
    Dto1 dto1 = new Dto1();
//    String str = "{\n" + "        \"name\": \"haris\",\n" + "        \"sex\": \"male\",\n"
//        + "        \"age\": 18,\n" + "        \"birthday\": \"1576463312\"\n" + "    }";

    String str = "{\n" + "    \"dto1\": {\n" + "        \"name\": \"haris\",\n"
        + "        \"sex\": \"male\",\n" + "        \"birthday\": \"1576486764000\"\n" + "    }\n" + "}";
//    dto1 = JSON.parseObject(str, Dto1.class);
//    Object object = JSONObject.parseObject(str, Dto2.class);

    JSONObject jsonObject = JSON.parseObject(str);
    System.out.println(JSON.toJSONString(jsonObject));
    String dto11 = jsonObject.getString("dto1");
    System.out.println(dto11);
    JSONObject jsonObject2 = JSON.parseObject(dto11);
    System.out.println(jsonObject2.getString("name"));
    System.out.println(jsonObject2.getString("sex"));
    System.out.println(jsonObject2.getString("birthday"));
    System.out.println(JSON.toJSONString(dto1));

//
//    String date1 = "20200305";
//    StringBuilder date2 = new StringBuilder();
//    date2.append(date1.substring(0,4)).append("-").append(date1.substring(4,6)).append("-").append(date1.substring(6,8));
//
//    Date date3 = new Date();
//    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//    sdf.format(date3);
//    System.out.println(date2.toString());
//    System.out.println(sdf.format(date3));





//    Date date = new Date();
//    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//    System.out.println(simpleDateFormat.format(date));  // 将Date数据格式化输出
//
//
//    System.out.println(jsonObject.toString());  // 直接利用parseObject方法转换成的JSONObject输出其字符串形式
//    System.out.println(calendar.getTime()); // 获取时间

    SimpleDateFormat dateFormatter2 = new SimpleDateFormat("yyyyMMdd");
    String formattedDate2 = dateFormatter2.format(new Date());
    System.out.println(formattedDate2);
    Long time = System.currentTimeMillis();
    System.out.println(time);

    Double n1 = new Double(12.789465);
    DecimalFormat df = new DecimalFormat("#.00");
    Double n2 = Double.parseDouble(df.format(n1));
    System.out.println(n2);

    Float f1 = new Float(9.04);
    DecimalFormat df2 = new DecimalFormat("#.0");
    Float f2 = Float.parseFloat(df2.format(f1));
    System.out.println(f2);

    // 2.555：两个都是2.55
    // 2.125：ROUND_HALF_UP是2.13，ROUND_HALF_DOWN是2.12
    BigDecimal d1 = new BigDecimal(2.555);
    BigDecimal d2 = d1.setScale(2, BigDecimal.ROUND_HALF_UP);
    BigDecimal d3 = d1.setScale(2, BigDecimal.ROUND_HALF_DOWN);
    System.out.println(d2);
    System.out.println(d3);

    try {
      Class<?> x = Class.forName("[I@#$%");
      System.out.println("[Getting class using Class.forName()]: " + x);

      x = ClassLoader.getSystemClassLoader().loadClass("[I");
      System.out.println("[Getting class using loadClass()]: " + x);
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    }

    System.out.println(UUID.randomUUID());
  }
}
