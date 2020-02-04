package com.example.demo.controller;

import com.example.demo.config.MyConfigBean;
import com.example.demo.domain.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
//@RequestMapping(value = "/api",produces = MediaType.APPLICATION_JSON_VALUE) 这句多余produces = MediaType.APPLICATION_JSON_VALUE
@RequestMapping(value = "/api")
public class MyController {
    @Value("${myConfig.myObject.myName}")
    private String myName;
    @Value("${myConfig.myObject.myAge}")
    private Integer myAge;

    @Autowired
    private MyConfigBean myConfigBean;

    @RequestMapping(value = "/test",method = RequestMethod.GET)
    public List<Person> test(){
        List<Person> list = new ArrayList<>();
        Person p = new Person();
        p.setId(1);
        p.setName(myName);
        p.setBirthday(new Date());
        p.setAge(myAge);
        list.add(p);
        //通过myConfigBean设置
        p = new Person();
        p.setId(2);
        p.setName(myConfigBean.getMyName());
        p.setBirthday(new Date());
        p.setAge(myConfigBean.getMyAge());
        list.add(p);
        return list;
    }
}
