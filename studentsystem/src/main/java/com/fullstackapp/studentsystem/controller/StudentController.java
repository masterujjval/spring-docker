package com.fullstackapp.studentsystem.controller; // This package is to write the HTTP methods and CRUD operations

import com.fullstackapp.studentsystem.model.Student;
import com.fullstackapp.studentsystem.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // it will give us the response body and the controller at the same time.
@RequestMapping("/student")
@CrossOrigin // it tells the application to connect cross platform (in this case it is react)
public class StudentController {
    @Autowired
    private StudentService studentService;

    // Now we need to write the logic to save the data in the database
    @PostMapping("/add") // HTTP method
    public String add(@RequestBody Student student){
        studentService.saveStudent(student);
        return "new student is added";
    }

    @GetMapping("/getAll")
    public List<Student> getAllStudents(){
        return  studentService.getAllStudents();
    }

}
