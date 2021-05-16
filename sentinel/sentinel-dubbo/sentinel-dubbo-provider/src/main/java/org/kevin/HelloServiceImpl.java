package org.kevin;

import org.apache.dubbo.config.annotation.DubboService;

@DubboService(version = "${service.version}", application = "${dubbo.application.id}",
        protocol = "${dubbo.protocol.id}", registry = "${dubbo.registry.id}")
public class HelloServiceImpl implements HelloService {
    @Override
    public String hello(String name) {
        return "hello " + name;
    }
}
