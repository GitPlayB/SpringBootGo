package com.nonchaos.Demos;

import org.springframework.util.CollectionUtils;

import java.util.*;

public class Test {
  public static void main(String[] args) {
//    Map<Long, Integer> map = new HashMap<>();
    Map<Long, Integer> map = newMap(false);
    System.out.println(CollectionUtils.isEmpty(map));
//    map.isEmpty();
//    System.out.println(map.isEmpty());

    List<Date> dateList = getTimeList();
    dateList.forEach(item -> System.out.println(item.toString()));
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
}
