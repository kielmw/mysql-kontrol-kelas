package com.example.mysqlkontrolkelas;

import com.example.mysqlkontrolkelas.Service.StudentService;
import com.example.mysqlkontrolkelas.model.Student;
import com.example.mysqlkontrolkelas.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

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
        students.forEach(student -> {
            Optional<Student> existingStudentOpt = studentRepository.findByNim(student.getNim());
            if (existingStudentOpt.isPresent()) {
                Student existingStudent = existingStudentOpt.get();
                // Update the existing student's information
                existingStudent.setNama(student.getNama());
                existingStudent.setNamaSekolah(student.getNamaSekolah());
                // Add other fields that need to be updated
                studentRepository.save(existingStudent);
            } else {
                studentRepository.save(student);
            }
        });
    }
}
