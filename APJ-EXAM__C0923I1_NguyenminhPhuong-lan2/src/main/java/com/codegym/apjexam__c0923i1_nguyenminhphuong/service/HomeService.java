package com.codegym.apjexam__c0923i1_nguyenminhphuong.service;

import com.codegym.apjexam__c0923i1_nguyenminhphuong.dto.StudentDTO;
import com.codegym.apjexam__c0923i1_nguyenminhphuong.model.Class;
import com.codegym.apjexam__c0923i1_nguyenminhphuong.model.Student;
import com.codegym.apjexam__c0923i1_nguyenminhphuong.repository.ClassRepository;
import com.codegym.apjexam__c0923i1_nguyenminhphuong.repository.StudentRepository;

import java.util.ArrayList;
import java.util.List;

public class HomeService {
    private StudentRepository studentRepository = new StudentRepository();
    private ClassRepository classRepository = new ClassRepository();
    public List<StudentDTO> findAll(){
        List<Student> studentList = studentRepository.findAll();
        List<StudentDTO> studentDTOList = new ArrayList<>();
        studentList.forEach(student -> {
            Class cl = classRepository.findById(student.getClass_id());
            StudentDTO studentDTO = buildStudentDTO(student, cl.getName());
            studentDTOList.add(studentDTO);
        });
        return studentDTOList;
    }

    public boolean editStudent(Student student){
        return studentRepository.updateById(student);
    }

    public StudentDTO findStudentDTOById(int id){
        Student student = studentRepository.findStudentById(id);
        Class cl = classRepository.findById(student.getClass_id());
        StudentDTO studentDTO = buildStudentDTO(student, cl.getName());
        return studentDTO;
    }

    public StudentDTO buildStudentDTO(Student student, String className){
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setId(student.getId());
        studentDTO.setName(student.getName());
        studentDTO.setAddress(student.getAddress());
        studentDTO.setPhone(student.getPhone());
        studentDTO.setDateOfBirth(student.getDateOfBirth());
        studentDTO.setEmail(student.getEmail());
        studentDTO.setClass_name(className);
        return studentDTO;
    }

    public List<Class> findAllClass(){
        return classRepository.findAll();
    }

    public void delete(int id){
        studentRepository.deleteById(id);
    }

    public void add(Student student){
        studentRepository.addStudent(student);
    }

    public List<StudentDTO> findAllByName(String name){
        List<Student> studentList = studentRepository.findAllByName(name);
        List<StudentDTO> studentDTOList = new ArrayList<>();
        studentList.forEach(student -> {
            Class cl = classRepository.findById(student.getClass_id());
            StudentDTO studentDTO = buildStudentDTO(student, cl.getName());
            studentDTOList.add(studentDTO);
        });
        return studentDTOList;
    }
}
