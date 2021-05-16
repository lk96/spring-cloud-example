package org.kevin;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "sentinel-feign-provider")
public interface HelloService {

    @GetMapping("/say/{name}")
    String say(@PathVariable("name") String name);
}
