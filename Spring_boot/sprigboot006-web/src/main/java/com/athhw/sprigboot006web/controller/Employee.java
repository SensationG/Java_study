package com.athhw.sprigboot006web.controller;

import com.athhw.sprigboot006web.dao.EmployeeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Collection;

@Controller
public class Employee {

    @Autowired
    EmployeeDao employeeDao = new EmployeeDao();

    @GetMapping("/emps")
    public String emplist(ModelAndView modelAndView){

        Collection<com.athhw.sprigboot006web.entities.Employee> employee = employeeDao.getAll();
        modelAndView.addObject("emps",employee);
        return "emp/list";
    }
}
