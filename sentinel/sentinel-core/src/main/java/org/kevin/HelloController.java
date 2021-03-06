package org.kevin;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.circuitbreaker.CircuitBreakerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
public class HelloController {

    @Autowired
    private RestTemplate restTemplate;

    @Resource
    private CircuitBreakerFactory circuitBreakerFactory;

    @GetMapping("/hello")
    @SentinelResource("resource")
    public String hello() {
        return "hello";
    }

    @GetMapping("/aa")
    @SentinelResource("aa")
    public String aa(int a, int b) {
        return "a b";
    }

    @GetMapping("/test")
    @SentinelResource("aa")
    public String test() {
        return "hello test";
    }

    @GetMapping("/template")
    public String client() {
        return restTemplate.getForObject("http://www.taobao.com/test", String.class);
    }

    @GetMapping("slow")
    public String slow() {
        return circuitBreakerFactory.create("slow").run(() -> {
            try {
                Thread.sleep(500L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "slow";
        }, throwable -> "fallback");
    }
}
