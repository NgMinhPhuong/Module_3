package com.example.apjexamc0923i1.model.dao.impl;

import com.example.apjexamc0923i1.Connection.JdbcConnection;
import com.example.apjexamc0923i1.model.dao.IEmployeeDAO;
import com.example.apjexamc0923i1.model.entity.Employee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAO implements IEmployeeDAO {
    public List<Employee> getAll(){
        String sql = "select * from employees";
        try(Connection c = JdbcConnection.getConnection();
            PreparedStatement preparedStatement = c.prepareStatement(sql);){
            ResultSet rs = preparedStatement.executeQuery();
            List<Employee> list = new ArrayList<>();
            int cnt = 1;
            while(rs.next()){
                Employee employee = new Employee();
                employee.setId(cnt++);
                employee.setEmail(rs.getString("email"));
                employee.setName(rs.getString("name"));
                employee.setAddress(rs.getString("address"));
                employee.setPhoneNumber(rs.getString("phonenumber"));
                employee.setSalary(rs.getString("salary"));
                employee.setDepartment(rs.getString("department"));
                list.add(employee);
            }
            return list;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void addEmployee(Employee employee) {
        String sql = "insert into employees(email,name,address,phonenumber,salary,department) values(?,?,?,?,?,?)";
        try(Connection c = JdbcConnection.getConnection();
            PreparedStatement preparedStatement = c.prepareStatement(sql);)
        {
            preparedStatement.setString(1, employee.getEmail());
            preparedStatement.setString(2, employee.getName());
            preparedStatement.setString(3, employee.getAddress());
            preparedStatement.setString(4, employee.getPhoneNumber());
            preparedStatement.setString(5, employee.getSalary());
            preparedStatement.setString(6, employee.getDepartment());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteEmployeeByEmail(String email) {
        String sql = "delete from employees where email = ?";
        try(Connection c = JdbcConnection.getConnection();
            PreparedStatement preparedStatement = c.prepareStatement(sql);)
        {
            preparedStatement.setString(1, email);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void updateEmployee(Employee employee) {
        String sql = "update employees set email = ?, name = ?, address = ?, phonenumber = ?, salary = ?, department = ? where email = ?";
        try(Connection c = JdbcConnection.getConnection();
            PreparedStatement preparedStatement = c.prepareStatement(sql);)
        {
            preparedStatement.setString(1, employee.getEmail());
            preparedStatement.setString(2, employee.getName());
            preparedStatement.setString(3, employee.getAddress());
            preparedStatement.setString(4, employee.getPhoneNumber());
            preparedStatement.setString(5, employee.getSalary());
            preparedStatement.setString(6, employee.getDepartment());
            preparedStatement.setString(7, employee.getEmail());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Employee getEmployeeByEmail(String email){
        String sql = "select * from employees where email = ?";
        try(Connection c = JdbcConnection.getConnection();
            PreparedStatement preparedStatement = c.prepareStatement(sql);){
            preparedStatement.setString(1, email);
            ResultSet rs = preparedStatement.executeQuery();
            rs.next();
                Employee employee = new Employee();
                employee.setEmail(email);
                employee.setName(rs.getString("name"));
                employee.setAddress(rs.getString("address"));
                employee.setPhoneNumber(rs.getString("phonenumber"));
                employee.setSalary(rs.getString("salary"));
                employee.setDepartment(rs.getString("department"));
                return employee;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Employee> searchEmployee(String key) {
        String sql = "select * from employees where name like ?";
        try(Connection c = JdbcConnection.getConnection();
            PreparedStatement preparedStatement = c.prepareStatement(sql);){
            preparedStatement.setString(1, key+"%");
            ResultSet rs = preparedStatement.executeQuery();
            List<Employee> list = new ArrayList<>();
            int cnt = 1;
            while(rs.next()){
                Employee employee = new Employee();
                employee.setId(cnt++);
                employee.setEmail(rs.getString("email"));
                employee.setName(rs.getString("name"));
                employee.setAddress(rs.getString("address"));
                employee.setPhoneNumber(rs.getString("phonenumber"));
                employee.setSalary(rs.getString("salary"));
                employee.setDepartment(rs.getString("department"));
                list.add(employee);
            }
            return list;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
