package com.codegym.apjexam__c0923i1_nguyenminhphuong.repository;

import com.codegym.apjexam__c0923i1_nguyenminhphuong.jdbcconnection.JdbcConnection;
import com.codegym.apjexam__c0923i1_nguyenminhphuong.model.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentRepository {
    private static final String FIND_ALL = "select * from student";
    private static final String UPDATE_STUDENT = "UPDATE student " +
            "set class_id = ?, name = ?, DateOfBirth = ?, email = ?, address = ?, phone = ? " +
            "where id = ?";
    private static final String FIND_STUDENT_BY_ID = "select * from student where id = ?";
    private static final String DELETE_BY_ID = "delete from student where id = ?";
    private static final String ADD_STUDENT = "insert into student(class_id,name,DateOfBirth,email,address,phone) values(?,?,?,?,?,?)";
    private static final String FIND_ALL_BY_NAME = "select * from student where name like ?";

    public List<Student> findAll(){
        List<Student> lists = new ArrayList<>();
        try(Connection c = JdbcConnection.getConnection();
            PreparedStatement preparedStatement = c.prepareStatement(FIND_ALL);){
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()){
                Student student = new Student();
                student.setId(Integer.parseInt(rs.getString("id")));
                student.setClass_id(Integer.parseInt(rs.getString("class_id")));
                student.setName(rs.getString("name"));
                student.setDateOfBirth(rs.getString("DateOfBirth"));
                student.setPhone(rs.getString("phone"));
                student.setEmail(rs.getString("email"));
                student.setAddress(rs.getString("address"));
                lists.add(student);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return lists;
    }

    public boolean updateById(Student student){
        try(Connection c = JdbcConnection.getConnection();
        PreparedStatement preparedStatement = c.prepareStatement(UPDATE_STUDENT);){
            preparedStatement.setString(1,student.getClass_id()+"");
            preparedStatement.setString(2, student.getName());
            preparedStatement.setString(3, student.getDateOfBirth());
            preparedStatement.setString(4, student.getEmail());
            preparedStatement.setString(5, student.getAddress());
            preparedStatement.setString(6, student.getPhone());
            preparedStatement.setString(7, student.getId()+"");
            if(preparedStatement.executeUpdate() > 0){
                return true;
            }
            return false;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Student findStudentById(int id){
        try(Connection c = JdbcConnection.getConnection();
            PreparedStatement preparedStatement = c.prepareStatement(FIND_STUDENT_BY_ID);){
            preparedStatement.setString(1, id +"");
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()){
                Student student = new Student();
                student.setId(Integer.parseInt(rs.getString("id")));
                student.setClass_id(Integer.parseInt(rs.getString("class_id")));
                student.setName(rs.getString("name"));
                student.setDateOfBirth(rs.getString("DateOfBirth"));
                student.setPhone(rs.getString("phone"));
                student.setEmail(rs.getString("email"));
                student.setAddress(rs.getString("address"));
                return student;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    public void deleteById(int id){
        try(Connection c = JdbcConnection.getConnection();
            PreparedStatement preparedStatement = c.prepareStatement(DELETE_BY_ID);){
            preparedStatement.setString(1, id+"");
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void addStudent(Student student){
        try(Connection c = JdbcConnection.getConnection();
            PreparedStatement preparedStatement = c.prepareStatement(ADD_STUDENT);){
            preparedStatement.setString(1, student.getClass_id()+"");
            preparedStatement.setString(2, student.getName());
            preparedStatement.setString(3, student.getDateOfBirth());
            preparedStatement.setString(4, student.getEmail());
            preparedStatement.setString(5, student.getAddress());
            preparedStatement.setString(6, student.getPhone());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Student> findAllByName(String name){
        List<Student> lists = new ArrayList<>();
        try(Connection c = JdbcConnection.getConnection();
            PreparedStatement preparedStatement = c.prepareStatement(FIND_ALL_BY_NAME);){
            preparedStatement.setString(1, "%"+name+"%");
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()){
                Student student = new Student();
                student.setId(Integer.parseInt(rs.getString("id")));
                student.setClass_id(Integer.parseInt(rs.getString("class_id")));
                student.setName(rs.getString("name"));
                student.setDateOfBirth(rs.getString("DateOfBirth"));
                student.setPhone(rs.getString("phone"));
                student.setEmail(rs.getString("email"));
                student.setAddress(rs.getString("address"));
                lists.add(student);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return lists;
    }
}
