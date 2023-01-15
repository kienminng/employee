package com.example.demo1.controller;

import com.example.demo1.modal.Employee;
import com.example.demo1.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class Home {
    @Autowired
    EmployeeService employeeService;

    @GetMapping("/home")
    public String home(Model model){
        model.addAttribute("employee",employeeService.getAll());
        return "index";
    }

    @GetMapping("/create")
    public String showCreate() {
        return "create";
    }

    @PostMapping("/create")
    public String save(Employee employee) {
        employeeService.save(employee);
        return "redirect:/home";
    }

    @GetMapping("/edit/{code}")
    public String showEdit() {
        return "edit";
    }

    @PostMapping("/edit/{code}")
    public String update(Employee employee){
        if (!employee.getName().equals("") && employee.getAge()!=0) {
            employeeService.edit(employee);
            return "redirect:/home";
        }else{
            return "edit";
        }
    }
    @GetMapping("/delete/{code}")
    public String delete(@PathVariable String code) {
        employeeService.delete(code);
        return "redirect:/home";
    }
}
