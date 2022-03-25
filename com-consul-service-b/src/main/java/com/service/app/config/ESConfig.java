package com.service.app.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * 与Consul的Key/Value的 config/consul-service,dev/data的值elasticsearch对应
 */
@Data
@ConfigurationProperties(prefix = "elasticsearch")
public class ESConfig {
    private String http_port;
    private String tcp_port;
    private String name;
    private String nodes;

    @Override
    public String toString() {
        return "ESConfig{" +
                "http_port='" + http_port + '\'' +
                ", tcp_port='" + tcp_port + '\'' +
                ", name='" + name + '\'' +
                ", nodes='" + nodes + '\'' +
                '}';
    }
}