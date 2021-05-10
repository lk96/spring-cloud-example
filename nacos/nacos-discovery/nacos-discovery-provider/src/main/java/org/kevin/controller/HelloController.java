package org.kevin.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: kai Li
 * Date: 2021/5/10 14:04
 * @Description:
 */
@RestController
public class HelloController {

    @Value("${server.port}")
    private int port;

    @Value("${spring.application.name}")
    private String serviceName;

    @GetMapping("/say/{name}")
    public String say(@PathVariable String name) {
        return String.format("[%s]response:%s", serviceName, name);
    }

    @GetMapping("/port")
    public int say() {
        return port;
    }
}
