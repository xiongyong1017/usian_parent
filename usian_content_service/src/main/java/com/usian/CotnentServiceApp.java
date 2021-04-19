package com.usian;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * 网站内容管理启动类
 *
 * @author : xy1201
 * @version 1.0
 * @date : 2021/4/16 17:25
 */
@SpringBootApplication
@EnableDiscoveryClient
@MapperScan("com.usian.mapper")
public class CotnentServiceApp {
    public static void main(String[] args) {
        SpringApplication.run(CotnentServiceApp.class, args);
    }
}
