package com.usian;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * 前台启动类
 *
 * @author : xy1201
 * @version 1.0
 * @date : 2021/4/19 19:30
 */
@SpringBootApplication
@EnableFeignClients
@EnableDiscoveryClient
public class PortalWebApp {
    public static void main(String[] args) {
        SpringApplication.run(PortalWebApp.class, args);
    }
}
