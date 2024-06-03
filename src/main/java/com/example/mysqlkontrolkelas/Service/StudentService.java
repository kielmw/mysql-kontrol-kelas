package com.example.mysqlkontrolkelas.Service;

import com.example.mysqlkontrolkelas.model.Student;
import com.example.mysqlkontrolkelas.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    public boolean deleteStudentByNim(int nim) {
        Optional<Student> studentOptional = studentRepository.findByNim(nim);
        if (studentOptional.isPresent()) {
            studentRepository.deleteById(studentOptional.get().getId().intValue());
            return true;
        }
        return false;
    }

//    public Student getStudentByNim(int nim) {
//        return studentRepository.findByNim(nim).orElse(null);
//    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }
}
