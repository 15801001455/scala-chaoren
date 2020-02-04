package com.example.demo.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
@Data
public class MyConfigBean {
    @Value("${myConfig.myObject.myName}")
    private String myName;
    @Value("${myConfig.myObject.myAge}")
    private Integer myAge;

}
