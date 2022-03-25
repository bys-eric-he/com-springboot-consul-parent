package com.consul.producer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@Slf4j
@SpringBootApplication
@EnableDiscoveryClient
/*由于Feign 的接口和请求参数对象是放在单独的模块中的,所以这里需要指定一下包路径*/
@EnableFeignClients(basePackages = "com.*")
@ComponentScan(basePackages = "com.*")
public class ProducerApplication {
    public static void main(String[] args) {
        SpringApplication.run(ProducerApplication.class, args);

        log.info("------------Service Producer Start SUCCESS-----");
    }
}