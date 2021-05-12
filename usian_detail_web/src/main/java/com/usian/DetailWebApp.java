package com.usian;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * 查询商品详情的启动类
 * @author : xy1201
 * @version 1.0
 * @date : 2021/5/6 17:00
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class DetailWebApp {
    public static void main(String[] args) {
        SpringApplication.run(DetailWebApp.class, args);
    }
}
