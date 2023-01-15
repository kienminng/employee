package com.example.demo1.DAO;

import com.example.demo1.modal.Employee;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;

public class EmployeeDAO {
    @Autowired
    EntityManager entityManager;

    public List<Employee> getAll(){
        String sql = "Select p from Employee p order by  p.age";
        List<Employee> employees = entityManager.createQuery(sql).getResultList();
        return employees;
    }

    public void save(Employee employee){
        EntityTransaction txn = entityManager.getTransaction();
        txn.begin();
        entityManager.persist(employee);
        txn.commit();
    }

    public void delete(Employee employee){
        EntityTransaction txn = entityManager.getTransaction();
        txn.begin();
        entityManager.remove(employee);
        txn.commit();
    }

    public void edit(Employee employee){
        EntityTransaction txn = entityManager.getTransaction();
        txn.begin();
        entityManager.merge(employee);
        txn.commit();
    }



    public Employee findByCode(String code){
        String sql = "Select p from Employee p where p.code = " + code;
        Employee employee = (Employee) entityManager.createQuery(sql).getSingleResult();
        return employee;
    }
}
