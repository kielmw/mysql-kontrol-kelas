package com.example.mysqlkontrolkelas;

import com.example.mysqlkontrolkelas.Service.StudentService;
import com.example.mysqlkontrolkelas.Service.TeacherService;
import com.example.mysqlkontrolkelas.model.Student;
import com.example.mysqlkontrolkelas.model.Teacher;
import com.example.mysqlkontrolkelas.repository.StudentRepository;
import com.example.mysqlkontrolkelas.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class DataLoader {

    private final StudentService studentService;
    private final StudentRepository studentRepository;
    private final TeacherService teacherService;
    private final TeacherRepository teacherRepository;

    @Autowired
    public DataLoader(StudentService studentService, StudentRepository studentRepository,
                      TeacherService teacherService, TeacherRepository teacherRepository) {
        this.studentService = studentService;
        this.studentRepository = studentRepository;
        this.teacherService = teacherService;
        this.teacherRepository = teacherRepository;
    }

    public void loadStudentData() {
        List<Student> students = studentService.getStudentsFromApi();
        students.forEach(student -> {
            Optional<Student> existingStudentOpt = studentRepository.findByNim(student.getNim());
            if (existingStudentOpt.isPresent()) {
                Student existingStudent = existingStudentOpt.get();
                existingStudent.setNama(student.getNama());
                existingStudent.setNamaSekolah(student.getNamaSekolah());
                // Add other fields that need to be updated
                studentRepository.save(existingStudent);
            } else {
                studentRepository.save(student);
            }
        });
    }

    public void loadTeacherData() {
        List<Teacher> teachers = teacherService.getTeachersFromApi();
        teachers.forEach(teacher -> {
            Optional<Teacher> existingTeacherOpt = teacherRepository.findByNip(teacher.getNip());
            if (existingTeacherOpt.isPresent()) {
                Teacher existingTeacher = existingTeacherOpt.get();
                existingTeacher.setNama(teacher.getNama());
                existingTeacher.setNamaSekolah(teacher.getNamaSekolah());
                // Add other fields that need to be updated
                teacherRepository.save(existingTeacher);
            } else {
                teacherRepository.save(teacher);
            }
        });
    }
}
