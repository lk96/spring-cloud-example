package org.kevin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @Author: kai Li
 * Date: 2021/5/10 15:04
 * @Description:
 */
@RestController
public class HelloController {

    private final RestTemplate restTemplate;

    @Autowired
    public HelloController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping("/say/{name}")
    public String say(@PathVariable String name) {
        return restTemplate.getForObject("http://nacos-discovery-provider/say/" + name, String.class);
    }

    @GetMapping("/port")
    public String get() {
        return restTemplate.getForObject("http://nacos-discovery-provider/port/", String.class);
    }
}
