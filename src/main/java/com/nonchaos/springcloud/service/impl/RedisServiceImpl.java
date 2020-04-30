package com.nonchaos.springcloud.service.impl;

import com.nonchaos.Redis.RedisUtils;
import com.nonchaos.springcloud.dto.RequestDto;
import com.nonchaos.springcloud.service.RedisService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RedisServiceImpl implements RedisService {
  @Autowired
  private static Logger logger = LoggerFactory.getLogger(RedisServiceImpl.class);

  @Autowired
  private RedisUtils redisUtils;

  @Override
  public void testRedis(RequestDto requestDto) {
    redisUtils.set("weather", "good");
    if (redisUtils.get("weather") != null) {
      logger.info("The value for key [weather] is,{}", redisUtils.get("weather"));
    }
  }
}
