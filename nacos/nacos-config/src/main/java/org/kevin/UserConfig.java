package org.kevin;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;
import java.util.Map;

/**
 * @Author: kai Li
 * Date: 2021/5/10 15:17
 * @Description:
 */
@ConfigurationProperties(prefix = "info")
@Getter
@Setter
@ToString
public class UserConfig {

    private String name;

    private int age;

    private String company;

    private Map<String, Object> map;

    private List<User> users;
}
