package org.kevin;

import com.alibaba.cloud.nacos.NacosConfigManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RefreshScope
public class UserController {

    @Resource
    private User user;

    @Resource
    private NacosConfigManager nacosConfigManager;

    @Resource
    private Environment environment;

    @GetMapping("/user")
    public String user(){
        return nacosConfigManager.getConfigService() + ":" + user.toString();
    }

    @RequestMapping("/get/{name}")
    public String getValue(@PathVariable String name) {
        return String.valueOf(environment.getProperty(name));
    }

    @RequestMapping("/exist")
    public boolean bool() {
        return (Boolean) (user.getMap().get("2"));
    }
}
