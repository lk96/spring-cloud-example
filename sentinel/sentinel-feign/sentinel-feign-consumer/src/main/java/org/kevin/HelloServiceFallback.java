package org.kevin;

public class HelloServiceFallback implements HelloService{

    private Throwable throwable;

    HelloServiceFallback(Throwable throwable) {
        this.throwable = throwable;
    }

    @Override
    public String say(String name) {
        return "sentinel-feign-consumer-default:" + throwable.getMessage();
    }
}
