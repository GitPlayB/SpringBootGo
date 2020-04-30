package com.nonchaos.springcloud.controller;

import com.alibaba.fastjson.JSON;
import com.nonchaos.springcloud.dto.RequestDto;
import com.nonchaos.springcloud.dto.ResponseDto;
import com.nonchaos.springcloud.service.RedisService;
import com.nonchaos.springcloud.service.impl.RedisServiceImpl;
import com.nonchaos.springcloud.util.CommonConstant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/test")
public class ApiTestController {
  @Autowired
  private static Logger logger = LoggerFactory.getLogger(RedisServiceImpl.class);

  @Autowired
  private RedisService redisServiceImpl;

  @RequestMapping(value = "/redis", method = RequestMethod.POST)
  public ResponseDto redis(@Validated @RequestBody RequestDto reqDto) {
    logger.info("测试redis,{}", JSON.toJSONString(reqDto));
    redisServiceImpl.testRedis(reqDto);
    return new ResponseDto(CommonConstant.SUCCESS_CODE, null, "操作成功");
  }
}
