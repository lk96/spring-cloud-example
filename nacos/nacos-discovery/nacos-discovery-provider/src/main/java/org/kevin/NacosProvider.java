package org.kevin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Author: kai Li
 * Date: 2021/5/10 11:00
 * @Description: nacos 注册发现
 */
@SpringBootApplication
@EnableDiscoveryClient
public class NacosProvider {

    public static void main(String[] args) {
        SpringApplication.run(NacosProvider.class, args);
    }
}
