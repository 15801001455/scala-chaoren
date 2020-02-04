package com.example.demo.domain;

import lombok.Data;

import java.util.Date;
@Data
public class Person {
    private Integer id;
    private String name;
    private Integer age;
    private Date birthday;
}
