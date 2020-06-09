package com.nonchaos.Demos;

import com.alibaba.fastjson.JSONObject;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.*;

import com.alibaba.fastjson.JSON;
import org.springframework.beans.BeanUtils;

public class Main {
  public static void main(String[] args) {
    String str = "{\n" + "    \"dto1\": {\n" + "        \"name\": \"haris\",\n"
        + "        \"sex\": \"male\",\n" + "        \"birthday\": \"1576486764000\"\n" + "    }\n" + "}";
    String str2 = "[{\"name\": \"haris\",\"sex\": \"male\",\"birthday\": \"1576486764000\"},{\"name\": \"jay\",\"sex\": \"male\",\"birthday\": \"1578364953000\"}]";

    Object object = JSONObject.parseObject(str, Dto2.class);
    System.out.println(object.toString());
    List<Dto1> dto1s = JSONObject.parseArray(str2, Dto1.class);
    dto1s.forEach(
        item -> System.out.println(item.toString())
    );

    JSONObject jsonObject = JSON.parseObject(str);
    System.out.println(JSON.toJSONString(jsonObject));
    System.out.println(jsonObject.toString());  // 直接利用parseObject方法转换成的JSONObject输出其字符串形式
    String dto11 = jsonObject.getString("dto1");
    System.out.println(dto11);
    JSONObject jsonObject2 = JSON.parseObject(dto11);
    System.out.println(jsonObject2.getString("name"));
    System.out.println(jsonObject2.getString("sex"));
    System.out.println(jsonObject2.getString("birthday"));


    /** 日期格式化 */
    String date1 = "20200305";
    StringBuilder date2 = new StringBuilder();
    date2.append(date1.substring(0,4)).append("-").append(date1.substring(4,6)).append("-").append(date1.substring(6,8));

    Date date3 = new Date();
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    sdf.format(date3);
    System.out.println(date2.toString());
    System.out.println(sdf.format(date3));

    Date date = new Date();
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    System.out.println(simpleDateFormat.format(date));  // 将Date数据格式化输出

    SimpleDateFormat dateFormatter2 = new SimpleDateFormat("yyyyMMdd");
    String formattedDate2 = dateFormatter2.format(new Date());
    System.out.println(formattedDate2);
    Long time = System.currentTimeMillis();
    System.out.println(time);

    /** DecimalFormat格式化实数 */
    Double n1 = new Double(12.789465);
    DecimalFormat df = new DecimalFormat("#.00");
    Double n2 = Double.parseDouble(df.format(n1));
    System.out.println(n2);

    Float f1 = new Float(9.04);
    DecimalFormat df2 = new DecimalFormat("#.0");
    Float f2 = Float.parseFloat(df2.format(f1));
    System.out.println(f2);

    /** BigDecimal设置精度 */
    // 2.555：两个都是2.55
    // 2.125：ROUND_HALF_UP是2.13，ROUND_HALF_DOWN是2.12
    BigDecimal d1 = new BigDecimal(2.555);
    BigDecimal d2 = d1.setScale(2, BigDecimal.ROUND_HALF_UP);
    BigDecimal d3 = d1.setScale(2, BigDecimal.ROUND_HALF_DOWN);
    System.out.println(d2);
    System.out.println(d3);

    /** JVM ClassNotFoundException异常测试 */
    try {
      Class<?> x = Class.forName("[I@#$%");
      System.out.println("[Getting class using Class.forName()]: " + x);

      x = ClassLoader.getSystemClassLoader().loadClass("[I");
      System.out.println("[Getting class using loadClass()]: " + x);
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    }

  }
}
