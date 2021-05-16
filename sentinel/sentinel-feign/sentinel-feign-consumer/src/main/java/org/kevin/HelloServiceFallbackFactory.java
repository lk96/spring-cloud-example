package org.kevin;

import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;

@Component
public class HelloServiceFallbackFactory implements FallbackFactory<HelloServiceFallback> {
    @Override
    public HelloServiceFallback create(Throwable cause) {
        return new HelloServiceFallback(cause);
    }
}
