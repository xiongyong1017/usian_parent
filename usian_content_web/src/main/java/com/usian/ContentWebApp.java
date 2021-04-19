package com.usian;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author : xy1201
 * @version 1.0
 * @date : 2021/4/18 18:43
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class ContentWebApp {
    public static void main(String[] args) {
        SpringApplication.run(ContentWebApp.class, args);
    }
}
