package com.nonchaos.Redis;

import com.nonchaos.StartUpApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.SimpleDateFormat;
import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CacheCounter {
  @Autowired
  private RedisUtils redisUtils;

  @Test
  public void test() {
    CacheCounter cacheCounter = new CacheCounter();
    String ID = cacheCounter.count();
    for (int i = 0; i < 10; i++) {
      System.out.println(ID);
      cacheCounter.count();
    }
  }

  public String count() {
//    redisUtils = new RedisUtils();
    StringBuilder CZUuid = new StringBuilder("CZ");
    Date date = new Date();
    SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
    String formattedDate = sdf.format(date);
    String key = CZUuid.append(formattedDate).toString();
    Long cache = 0l;
    if (redisUtils.hasKey(key)) {
      cache = (Long) redisUtils.get(key);
    }
    if (cache == null) {
      Long num = 1l;
      redisUtils.set(key, 2l);
    } else {
      Long newNum = redisUtils.increment(key, 1l);
      cache = newNum;
    }

    return CZUuid.append(formattedDate).append(cache).toString();
  }
}
