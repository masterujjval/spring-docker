package com.fullstackapp.studentsystem.repository; // this package is for JPA implementation

import com.fullstackapp.studentsystem.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

}
