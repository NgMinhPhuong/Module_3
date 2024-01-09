package com.example.apjexamc0923i1.model.service;

import com.example.apjexamc0923i1.model.entity.Employee;

import java.util.List;

public interface IEmployeeService {
    public List<Employee> getAll();
    void add(Employee employee);
    void delete(String email);
    void edit(Employee employee);
    Employee getEmployeeByEmail(String email);
    List<Employee> search(String key);
}
