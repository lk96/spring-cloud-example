package org.kevin;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: kai Li
 * Date: 2021/5/10 15:52
 * @Description:
 */
@RestController
@RequestMapping("/test")
@RefreshScope
public class TestController {

    @Value("${useLocalCache}")
    private String useLocalCache;

    @RequestMapping("/get")
    public String get() {
        return useLocalCache;
    }
}
