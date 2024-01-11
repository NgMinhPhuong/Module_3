package com.example.apjexamc0923i1.model.service.impl;

import com.example.apjexamc0923i1.model.dao.IEmployeeDAO;
import com.example.apjexamc0923i1.model.dao.impl.EmployeeDAO;
import com.example.apjexamc0923i1.model.entity.Employee;
import com.example.apjexamc0923i1.model.service.IEmployeeService;

import java.sql.SQLException;
import java.util.List;

public class EmployeeService implements IEmployeeService {
    IEmployeeDAO iEmployeeDAO;
    public EmployeeService(){
        iEmployeeDAO = new EmployeeDAO();
    }
    @Override
    public List<Employee> getAll() {
        return iEmployeeDAO.getAll();
    }

    @Override
    public void add(Employee employee) {
        iEmployeeDAO.addEmployee(employee);
    }

    @Override
    public void delete(String email) {
        iEmployeeDAO.deleteEmployeeByEmail(email);
    }

    @Override
    public void edit(Employee employee) {
        iEmployeeDAO.updateEmployee(employee);
    }

    @Override
    public Employee getEmployeeByEmail(String email) {
        return iEmployeeDAO.getEmployeeByEmail(email);
    }

    @Override
    public List<Employee> search(String key) {
        return iEmployeeDAO.searchEmployee(key);
    }
}
