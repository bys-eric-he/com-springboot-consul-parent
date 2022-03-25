package com.consul.facade;

import com.consul.model.RequestParamModel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * name 是application.yml中的spring.application.name
 */
@FeignClient(name = "consul-service-producer", fallback = ProduceServiceRemoteHystrix.class)
public interface ProduceServiceRemote {
    @RequestMapping(value = "/api/producer/user",
            method = RequestMethod.POST,
            produces = "application/json;charset=UTF-8")
    String queryUser(@RequestBody RequestParamModel request);
}
