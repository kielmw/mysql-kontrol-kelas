package com.example.mysqlkontrolkelas.Service;

import com.example.mysqlkontrolkelas.model.Student;
import com.example.mysqlkontrolkelas.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    public Student findStudentById(int nim) {
        return studentRepository.findByNim(nim).orElse(null);
    }
}
