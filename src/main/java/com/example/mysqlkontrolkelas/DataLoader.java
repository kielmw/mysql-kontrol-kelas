package com.example.mysqlkontrolkelas;

import com.example.mysqlkontrolkelas.Service.StudentService;
import com.example.mysqlkontrolkelas.model.Student;
import com.example.mysqlkontrolkelas.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DataLoader {

    private final StudentService studentService;
    private final StudentRepository studentRepository;

    @Autowired
    public DataLoader(StudentService studentService, StudentRepository studentRepository) {
        this.studentService = studentService;
        this.studentRepository = studentRepository;
    }

    public void loadStudentData() {
        List<Student> students = studentService.getStudentsFromApi();
        students.forEach(studentRepository::save);
    }
}
