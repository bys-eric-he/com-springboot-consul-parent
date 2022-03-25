package com.service.app.controller;

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
    private ESConfig esConfig;

    @RequestMapping(value = "/name", method = RequestMethod.GET)
    public CommonResult<String> queryName(@RequestParam String userId) {
        log.info("---Service B queryName 请求到达----");
        return CommonResult.success("UserID:" + userId + "Service - B - Controller !!!", "请求成功, 处理服务端口：" + serverPort);
    }

    @RequestMapping(value = "/es-config", method = RequestMethod.GET)
    public CommonResult<String> getESConfig() {
        log.info("---Service B get ESConfig 请求到达----");
        return CommonResult.success(esConfig.toString(), "请求成功, 处理服务端口：" + serverPort);
    }
}
