package com.example.mysqlkontrolkelas;

import com.example.mysqlkontrolkelas.Service.StudentService;
import com.example.mysqlkontrolkelas.model.Student;
import com.example.mysqlkontrolkelas.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DataLoader implements CommandLineRunner {

    private final StudentService studentService;
    private final StudentRepository studentRepository; // Assuming you have a StudentRepository

    @Autowired
    public DataLoader(StudentService studentService, StudentRepository studentRepository) {
        this.studentService = studentService;
        this.studentRepository = studentRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        List<Student> students = studentService.getStudentsFromApi();
        students.forEach(student -> {
            // Save each student to the database
            studentRepository.save(student);
        });
    }
}

