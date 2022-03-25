package com.service.app.controller;

import com.consul.facade.ProduceServiceRemote;
import com.consul.model.RequestParamModel;
import com.consul.model.response.CommonResult;
import com.service.app.config.ESConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping(path = "/api/app")
public class AppController {
    @Value("${server.port}")
    private String serverPort;

    @Autowired
    private ProduceServiceRemote produceServiceRemote;

    @Autowired
    private ESConfig esConfig;

    @RequestMapping(value = "/user", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public CommonResult<String> queryUser(@RequestBody RequestParamModel request) {
        log.info("---Service A queryUser 请求到达----");
        return CommonResult.success(produceServiceRemote.queryUser(request), "请求成功, 处理服务端口：" + serverPort);
    }

    @RequestMapping(value = "/name", method = RequestMethod.GET)
    public CommonResult<String> queryName(@RequestParam String userId) {
        log.info("---Service A queryName 请求到达----");
        return CommonResult.success("UserID:" + userId + "Service - A - Controller !!!", "请求成功, 处理服务端口：" + serverPort);
    }

    @RequestMapping(value = "/es-config", method = RequestMethod.GET)
    public CommonResult<String> getESConfig() {
        log.info("---Service A get ESConfig 请求到达----");
        return CommonResult.success(esConfig.toString(), "请求成功, 处理服务端口：" + serverPort);
    }
}
