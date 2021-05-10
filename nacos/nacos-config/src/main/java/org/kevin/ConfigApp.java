package org.kevin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * @Author: kai Li
 * Date: 2021/5/10 15:16
 * @Description:
 */
@SpringBootApplication
public class ConfigApp {

    public static void main(String[] args) {
        SpringApplication.run(ConfigApp.class, args);
    }

    @Bean
    public UserConfig userConfig(){
        return new UserConfig();
    }
}
