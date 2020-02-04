package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConfig {

    @Bean //这个注解必须有 代表当前对象是spring管辖的bean
    public MyConfigBean myConfigBean(){
        return new MyConfigBean();
    }

}


