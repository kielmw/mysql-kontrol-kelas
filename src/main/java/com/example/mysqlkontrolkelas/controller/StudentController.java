package com.example.mysqlkontrolkelas.controller;

import com.example.mysqlkontrolkelas.Service.StudentService;
import com.example.mysqlkontrolkelas.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping
    public ResponseEntity<Student> createStudent(@RequestBody Student student) {
        Student savedStudent = studentService.saveStudent(student);
        return ResponseEntity.ok(savedStudent);
    }
    @DeleteMapping("/{nim}")
    public ResponseEntity<Void> deleteStudent(@PathVariable int nim) {
        boolean isDeleted = studentService.deleteStudentByNim(nim);
        if (isDeleted) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}