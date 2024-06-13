package com.example.mysqlkontrolkelas.controller;

import com.example.mysqlkontrolkelas.DataLoader;
import com.example.mysqlkontrolkelas.Service.TeacherService;
import com.example.mysqlkontrolkelas.model.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TeacherController {

    @Autowired
    private TeacherService teacherService;

    @GetMapping("/api/teachers")
    public List<Teacher> getAllTeachers() {
        return teacherService.getAllTeachers();
    }

}
