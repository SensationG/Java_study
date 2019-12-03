package com.athhw.springboot003config.controller;


import com.athhw.springboot003config.bean.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class mycontroller {

    @Autowired
    Person p = new Person();

    @ResponseBody
    @RequestMapping("/person")
    public String show(){

        return p.getLastName();
    }

}
