package com.example.demo.student;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/v1/student")
public class StudentController {

    private final StudentService StudentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.StudentService = studentService;
    }

    @GetMapping
    public List<Student> getStudents() {
        return StudentService.getStudents();
    }

    @PostMapping
    public void registerNewStudent(@RequestBody Student student) {
        StudentService.addNewStudent(student);
    }

    @DeleteMapping(path = "{studentId}")
    public void deleteStudent(@PathVariable("studentId") long studentId) {
        StudentService.deleteStudent(studentId);
    }
}
