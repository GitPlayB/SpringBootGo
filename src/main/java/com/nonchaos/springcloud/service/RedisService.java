package com.nonchaos.springcloud.service;

import com.nonchaos.springcloud.dto.RequestDto;

public interface RedisService {
  void testRedis(RequestDto requestDto);
}
