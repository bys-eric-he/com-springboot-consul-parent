package com.consul.facade;

import com.consul.model.response.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "consul-service" , fallback = AServiceRemoteHystrix.class)
public interface AServiceRemote {
    @GetMapping("/api/app/name")
    CommonResult<String> queryName(@RequestParam String userId);

    @GetMapping("/api/app/es-config")
    CommonResult<String> getESConfig();
}
