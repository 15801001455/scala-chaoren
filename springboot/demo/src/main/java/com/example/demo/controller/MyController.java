package com.example.demo.controller;

import com.example.demo.domain.Person;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
//@RequestMapping(value = "/api",produces = MediaType.APPLICATION_JSON_VALUE) 这句多余produces = MediaType.APPLICATION_JSON_VALUE
@RequestMapping(value = "/api")
public class MyController {

    @RequestMapping(value = "/test",method = RequestMethod.GET)
    public Person test(){
        Person p = new Person();
        p.setId(3);
        p.setName("张三");
        p.setBirthday(new Date());
        return p;
    }
}
