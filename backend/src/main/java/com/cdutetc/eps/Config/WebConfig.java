package com.cdutetc.eps.Config;

import java.nio.file.PathMatcher;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.method.HandlerTypePredicate;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer{
    // 移除了自动添加/api前缀的配置，避免路径重复拼接问题
    // 如果需要统一前缀，建议在application.yml中配置spring.mvc.servlet.path=/api
    // 或者在各控制器的@RequestMapping中显式添加前缀

}