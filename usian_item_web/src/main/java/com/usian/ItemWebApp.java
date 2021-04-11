package com.usian;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * web启动类
 *
 * @author : xy1201
 * @version 1.0
 * @date : 2021/4/7 20:34
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class ItemWebApp {
    public static void main(String[] args) {
        SpringApplication.run(ItemWebApp.class, args);
    }
}
