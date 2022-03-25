package com.service.app;

import com.service.app.config.ESConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@Slf4j
@SpringBootApplication
@EnableDiscoveryClient
/*由于Feign 的接口和请求参数对象是放在单独的模块中的,所以这里需要指定一下包路径*/
@EnableFeignClients(basePackages = "com.*")
@ComponentScan(basePackages = "com.*")
//指定配置类
@EnableConfigurationProperties({ESConfig.class})
public class ServiceAApplication {
    public static void main(String[] args) {
        SpringApplication.run(ServiceAApplication.class, args);

        log.info("------------Service -A Start SUCCESS-----");
    }
}
