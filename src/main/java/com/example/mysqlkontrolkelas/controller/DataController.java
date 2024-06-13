package com.example.mysqlkontrolkelas.controller;

import com.example.mysqlkontrolkelas.DataLoader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DataController {

    private final DataLoader dataLoader;

    @Autowired
    public DataController(DataLoader dataLoader) {
        this.dataLoader = dataLoader;
    }

    @PostMapping("/reload-students")
    public String reloadStudents() {
        dataLoader.loadStudentData();
        return "Student data reloaded successfully";
    }

    @PostMapping ("/reload-teachers")
    public String reloadTeachers() {
        dataLoader.loadTeacherData();
        return "Teacher data reloaded successfully";
    }
}
