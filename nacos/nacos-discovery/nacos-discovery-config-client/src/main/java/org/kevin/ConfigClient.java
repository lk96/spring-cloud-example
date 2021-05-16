package org.kevin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Author: kai Li
 * Date: 2021/5/10 17:28
 * @Description:
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ConfigClient {

    public static void main(String[] args) {
        SpringApplication.run(ConfigClient.class, args);
    }
}
