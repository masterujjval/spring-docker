package com.fullstackapp.studentsystem.service;

import com.fullstackapp.studentsystem.model.Student;

import java.util.List;

public interface StudentService {
    public Student saveStudent(Student student);
    public List<Student> getAllStudents();
}
