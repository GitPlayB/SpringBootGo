package com.nonchaos.job.xxljob.mvc.controller;//package com.xxl.job.executor.mvc.controller;
//
import com.nonchaos.job.xxljob.service.jobhandler.SampleXxlJob;
import com.xxl.job.core.biz.model.ReturnT;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

//@Controller
@RestController(value = "/")
@EnableAutoConfiguration
public class IndexController {
    @Autowired
    SampleXxlJob sampleXxlJob;

    @RequestMapping("/")
    @ResponseBody
    String index() {
        return "xxl job executor running.";
    }

    @RequestMapping("/demoJob")
    @ResponseBody
    ReturnT<String> demoJob() throws Exception{
        return sampleXxlJob.demoJobHandler("hello, it's a sample demo job");
    }

    @RequestMapping("/shardingJob")
    @ResponseBody
    ReturnT<String> shardingJob() throws Exception{
        return sampleXxlJob.shardingJobHandler("hello, it's a sharding job");
    }

    @RequestMapping("/commandJob")
    @ResponseBody
    ReturnT<String> commandJob() throws Exception{
        return sampleXxlJob.commandJobHandler("hello, it's a command job");
    }

    @RequestMapping(value = "/httpJob", method = RequestMethod.GET)
    @ResponseBody
    ReturnT<String> httpJob(@RequestParam String param) throws Exception{
        return sampleXxlJob.httpJobHandler(param);
    }

    @RequestMapping("/demoJob2")
    @ResponseBody
    ReturnT<String> demoJob2() throws Exception{
        return sampleXxlJob.demoJobHandler2("hello, it's another sample demo job");
    }
}
