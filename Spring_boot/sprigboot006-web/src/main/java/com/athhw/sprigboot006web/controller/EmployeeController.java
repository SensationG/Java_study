package com.athhw.sprigboot006web.controller;

import com.athhw.sprigboot006web.dao.DepartmentDao;
import com.athhw.sprigboot006web.dao.EmployeeDao;
import com.athhw.sprigboot006web.entities.Department;
import com.athhw.sprigboot006web.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Collection;

@Controller
public class EmployeeController {

    @Autowired
    EmployeeDao employeeDao = new EmployeeDao();
    @Autowired
    DepartmentDao departmentDao = new DepartmentDao();

    //查询员工列表
    @GetMapping("/emps")
    public ModelAndView  emplist(ModelAndView modelAndView){

        Collection<com.athhw.sprigboot006web.entities.Employee> employee = employeeDao.getAll();
        //model.addAttribute("emps",employee);
        modelAndView.addObject("emps",employee);
        modelAndView.setViewName("emp/list");
        return modelAndView;
    }

    //进入员工添加页面
    @GetMapping("/toAddEmp")
    public String toAddPage(Model model){
        Collection<Department> department=departmentDao.getDepartments();
        model.addAttribute("dIds",department);
        return "emp/add";
    }

    //员工添加处理 添加完后跳转到其他的Controller处理
    //SpringMVC自动将请求参数和形参对象属性进行一一绑定：要求请求参数的名字和javabean形参对象里面的属性名name相同
    @PostMapping("/addEmp")
    public String addEmp(Employee employee){

        System.out.println("保存的员工信息："+employee);
        employeeDao.save(employee);//保存员工
        //添加完返回列表页面 return /emps的Controller处理
        //redirect: 重定向一个地址  /代表当前项目路径
        //foward: 转发到一个地址
        return "redirect:/emps";
    }

    //来到员工数据修改页面
    //注明id是路径变量 @PathVariable 请求路径也为{id}可变值
    @GetMapping("/emp/{id}")
    public String toEditPage(@PathVariable("id") Integer id,Model model){
        //先查找员工
        Employee employee=employeeDao.get(id);
        model.addAttribute("emps",employee);
        //显示所有部门
        Collection<Department> department=departmentDao.getDepartments();
        model.addAttribute("dIds",department);
        //返回添加页面
        return "/emp/Edit";
    }

    //员工数据修改
    @PostMapping("/editEmp")
    public String updateEmployee(Employee employee){
        System.out.println("修改的员工数据："+employee);
        employeeDao.save(employee);
        //回到emps 的controller处理
        return "redirect:/emps";
    }
}
