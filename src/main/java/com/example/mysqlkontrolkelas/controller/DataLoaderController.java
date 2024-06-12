package com.example.mysqlkontrolkelas.controller;

import com.example.mysqlkontrolkelas.DataLoader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DataLoaderController {

    private final DataLoader dataLoader;

    @Autowired
    public DataLoaderController(DataLoader dataLoader) {
        this.dataLoader = dataLoader;
    }

    @PostMapping("/reload-students")
    public void reloadStudents() {
        dataLoader.loadStudentData();
    }
}
