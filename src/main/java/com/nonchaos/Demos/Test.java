package com.nonchaos.Demos;

import org.springframework.util.CollectionUtils;

import java.text.SimpleDateFormat;
import java.util.*;

public class Test {
  public static void main(String[] args) {
//    Map<Long, Integer> map = new HashMap<>();
    Map<Long, Integer> map = newMap(false);
    System.out.println(CollectionUtils.isEmpty(map));
//    map.isEmpty();
//    System.out.println(map.isEmpty());

    List<Date> dateList = getTimeList();
//    dateList.forEach(item -> System.out.println(item.toString()));
    Test.stringValidator("avbd$");

    Test test = new Test();
    Calendar calendar = Calendar.getInstance();
    Date askTime = new Date(1591009260000L);
    Date answerTime = new Date(1591009800000L);
    long replyTime = test.getDialogReplyTime(askTime, answerTime, calendar) - TimeZone.getDefault().getRawOffset();
    SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
    System.out.println("replyTime(milliseconds): " + replyTime);
    System.out.println("replyTime: " + sdf.format(replyTime));
  }

  public static Map<Long, Integer> newMap(boolean flag) {
    if (flag) {
      Map<Long, Integer> map = new HashMap<>();
      return map;
    } else {
      return null;
    }
  }

  private static List<Date> getTimeList(){
    List<Date> workTimeList = new ArrayList<>();
    Calendar cal = Calendar.getInstance();
    Calendar calendar = Calendar.getInstance();
    calendar.setTime(new Date());
    calendar.set(Calendar.HOUR_OF_DAY, 0);
    calendar.set(Calendar.MINUTE, 0);
    calendar.set(Calendar.SECOND, 0);
    calendar.set(Calendar.MILLISECOND, 0);
    workTimeList.add(calendar.getTime());
    calendar.set(Calendar.HOUR_OF_DAY,8);
    workTimeList.add(calendar.getTime());
    calendar.set(Calendar.HOUR_OF_DAY,23);
    workTimeList.add(calendar.getTime());
    workTimeList.add(null);
    workTimeList.add(null);
    return workTimeList;
  }

  /**
   * 检测是否有特殊字符：^'/\"()@$%*<>&?!
   * @param s
   */
  public static void stringValidator(String s) {
    String REGEX =
        "^[^\\\\^\\\\'\\\\/\\\\\\\\\\\\\"\\\\(\\\\)@\\\\$%\\\\*\\\\<\\\\>&\\\\?\\\\!]*$";
    // \\^\\'\\/\\\\\\"\\(\\)@\\$%\\*\\<\\>&\\?\\!
    // \^\'\/\\\"\(\)@\$%\*\<\>&\?\!
    // ^'/\"()@$%*<>&?!
    if (!s.matches(REGEX)) {
      System.out.println("Congratulations! This is a well-formed string.");
    } else {
      System.out.println("Sorry! The string is illegal.");
    }
  }

  private long getDialogReplyTime(Date askTime, Date answerTime, Calendar calendar){
    calendar.setTime(askTime);
    int askHour = calendar.get(Calendar.HOUR_OF_DAY);
    if(askHour < 8){
      setHourTime(calendar, 8, 0, 0, 0);
    }else if (askHour >= 12 && askHour < 14){
      setHourTime(calendar, 14, 0, 0, 0);
    }else if(askHour >= 18){
      setHourTime(calendar, 23, 59, 59,999);
    }
    long askTimeStamp = calendar.getTime().getTime();
    long replyTime =  answerTime.getTime() - askTimeStamp;
    return replyTime>0?replyTime:0;
  }

  private void setHourTime(Calendar calendar, int hour, int minute, int second, int millisecond){
    calendar.set(Calendar.HOUR_OF_DAY, hour);
    calendar.set(Calendar.MINUTE, 0);
    calendar.set(Calendar.SECOND, 0);
    calendar.set(Calendar.MILLISECOND, 0);
  }
}
