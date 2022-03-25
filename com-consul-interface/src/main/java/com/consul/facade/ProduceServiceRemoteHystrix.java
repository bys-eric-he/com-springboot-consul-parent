package com.consul.facade;

import com.consul.model.RequestParamModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

@Slf4j
@Component
public class ProduceServiceRemoteHystrix implements ProduceServiceRemote {
    @Override
    public String queryUser(@RequestBody RequestParamModel request) {
        log.info("----Consul-Service-Producer->服务降低！！----");
        return "Produce Service Remote->服务降低！！";
    }
}
