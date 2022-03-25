package com.consul.producer.controller;

import com.consul.facade.AServiceRemote;
import com.consul.model.RequestParamModel;
import com.consul.model.response.CommonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping(path = "/api/producer")
public class ProducerController {

    @Value("${server.port}")
    private String serverPort;

    @Autowired
    private AServiceRemote aServiceRemote;

    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public String queryUser(@RequestBody RequestParamModel request) {
        log.info("-----------Producer Service Query User 请求到达-------------");
        return "端口:" + serverPort + " hello, " + request.getUserName() + "！";
    }

    @RequestMapping(value = "/name", method = RequestMethod.GET)
    public CommonResult<String> queryName(@RequestParam String userId) {
        log.info("-----------Producer Service Query Name 请求到达-------------");
        return aServiceRemote.queryName(userId);
    }

    @RequestMapping(value = "/es-config", method = RequestMethod.GET)
    public CommonResult<String> getESConfig() {
        log.info("-----------Producer Service get ESConfig 请求到达-------------");
        return aServiceRemote.getESConfig();
    }
}
