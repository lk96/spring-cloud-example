package org.kevin;

import org.apache.dubbo.config.annotation.DubboReference;

public class HelloServiceConsumer {

    @DubboReference(version = "${service.version}",
            application = "${dubbo.application.id}",
            url = "dubbo://localhost:12345?version=1.0.0", timeout = 30000)
    private HelloService helloService;

    public String hello(String name) {
        return helloService.hello(name);
    }
}
