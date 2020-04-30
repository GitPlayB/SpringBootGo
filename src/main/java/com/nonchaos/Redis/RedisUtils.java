package com.nonchaos.Redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

@Component
public class RedisUtils {
  @Autowired
  private RedisTemplate redisTemplate;

//  @Autowired
//  private StringRedisTemplate stringRedisTemplate;

  public Boolean hasKey(String key) {
    return key != null ? this.redisTemplate.hasKey(key) : false;
  }

  public Object get(String key) {
    return null != key ? this.redisTemplate.opsForValue().get(key) : null;
  }

  public void set(String key, Object value) {
    if (null != key) {
      this.redisTemplate.opsForValue().set(key, value);
    }
  }

  public void set(String key, Object value, long time) {
    if (null != key) {
      this.set(key, value);
      this.redisTemplate.expire(key, time, TimeUnit.SECONDS);
    }
  }

  public Long increment(String key, long delta) {
    return this.redisTemplate.opsForValue().increment(key, delta);
  }
}
