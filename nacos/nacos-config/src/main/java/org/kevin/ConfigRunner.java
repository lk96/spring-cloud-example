package org.kevin;

import com.alibaba.cloud.nacos.NacosConfigManager;
import com.alibaba.nacos.api.config.listener.Listener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.io.IOException;
import java.io.StringReader;
import java.util.Properties;
import java.util.concurrent.Executor;

@Component
public class ConfigRunner implements ApplicationRunner {

    @Resource
    private NacosConfigManager nacosConfigManager;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        nacosConfigManager.getConfigService().addListener("nacos-config-example.properties", "DEFAULT_GROUP", new Listener() {
                    @Override
                    public Executor getExecutor() {
                        return null;
                    }

                    @Override
                    public void receiveConfigInfo(String configInfo) {
                        Properties properties = new Properties();
                        try {
                            properties.load(new StringReader(configInfo));
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        System.out.println("config changed: " + properties);
                    }
                }
        );
    }
}
