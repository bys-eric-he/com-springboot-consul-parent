package com.consul.facade;

import com.consul.model.response.CommonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

@Slf4j
@Component
public class AServiceRemoteHystrix implements AServiceRemote {
    @Override
    public CommonResult<String> queryName(@RequestParam String userId) {
        log.info("----A-Service-Remote queryName->服务降低！！----");
        return CommonResult.success("A Service Remote->服务降低！！");
    }

    @Override
    public CommonResult<String> getESConfig() {
        log.info("----A-Service-Remote getESConfig->服务降低！！----");
        return CommonResult.success("A Service Remote getESConfig->服务降低！！");
    }
}
