package org.kevin;

import com.alibaba.cloud.nacos.NacosConfigManager;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author: kai Li
 * Date: 2021/5/10 15:26
 * @Description:
 */
@RestController
@RefreshScope
public class ConfigController {

    @Resource
    private UserConfig userConfig;

    @Resource
    private NacosConfigManager nacosConfigManager;

    @Resource
    private Environment environment;

    @Value("${info.name:kevin}")
    private String userName;

    @Value("${info.age:18}")
    private int age;

    @GetMapping("/user")
    public String user() {
        return String.format("nacos config: name:%S,age:%d. [userConfig]:%s.%s", userName, age, userConfig,
                nacosConfigManager.getConfigService());
    }

    @GetMapping("/get/{name}")
    public String getValue(@PathVariable String name) {
        return String.valueOf(environment.getProperty(name));
    }

    @GetMapping("/bool")
    public boolean bool() {
        return (Boolean) (userConfig.getMap().get("1"));
    }
}
