package org.kevin;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Getter
@Setter
@ToString
@ConfigurationProperties(prefix = "user")
@Component
public class User {

    private String name;

    private String company;

    private int age;

    private Map<String, Object> map;

    private List<String> list;
}
