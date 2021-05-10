package org.kevin;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: kai Li
 * Date: 2021/5/10 17:29
 * @Description:
 */
@RestController
public class ConfigController {

    @Value("${name}")
    private String name;

    @GetMapping("/name")
    public String getName() {
        return name;
    }
}
