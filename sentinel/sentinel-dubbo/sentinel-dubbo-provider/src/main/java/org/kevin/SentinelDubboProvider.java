package org.kevin;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class SentinelDubboProvider {

    public static void main(String[] args) {
        SpringApplicationBuilder builder = new SpringApplicationBuilder();
        builder.web(WebApplicationType.NONE)
                .sources(SentinelDubboProvider.class).run(args);
    }
}
