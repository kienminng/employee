package com.example.demo1.service;

import com.example.demo1.DAO.EmployeeDAO;
import com.example.demo1.modal.Employee;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class EmployeeService {
    @Autowired
    EmployeeDAO employeeDAO;

    public List<Employee> getAll(){
        return employeeDAO.getAll();
    }

    public void delete(String code){
        employeeDAO.delete(employeeDAO.findByCode(code));
    }

    public void edit(Employee employee){
        employeeDAO.edit(employee);
    }

    public void save(Employee employee){
        employeeDAO.save(employee);
    }
}
