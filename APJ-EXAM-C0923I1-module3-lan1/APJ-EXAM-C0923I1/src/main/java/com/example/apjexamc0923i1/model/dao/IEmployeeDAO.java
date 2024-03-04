package com.example.apjexamc0923i1.model.dao;

import com.example.apjexamc0923i1.model.entity.Employee;

import java.util.List;

public interface IEmployeeDAO {
    public List<Employee> getAll();
    void addEmployee(Employee employee);
    void deleteEmployeeByEmail(String email);
    void updateEmployee(Employee employee);

    Employee getEmployeeByEmail(String email);
    List<Employee> searchEmployee(String key);

}
