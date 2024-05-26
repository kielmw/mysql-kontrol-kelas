package com.example.mysqlkontrolkelas.Service;

import com.example.mysqlkontrolkelas.model.KontrolKelas;
import com.example.mysqlkontrolkelas.model.KontrolKelasStudent;
import com.example.mysqlkontrolkelas.model.KontrolKelasStudentId;
import com.example.mysqlkontrolkelas.model.Student;
import com.example.mysqlkontrolkelas.repository.KontrolKelasRepository;
import com.example.mysqlkontrolkelas.repository.KontrolKelasStudentRepository;
import com.example.mysqlkontrolkelas.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class KontrolKelasStudentService {

    @Autowired
    private KontrolKelasStudentRepository kontrolKelasStudentRepository;

    @Autowired
    private KontrolKelasRepository kontrolKelasRepository;

    @Autowired
    private StudentRepository studentRepository;

    public KontrolKelasStudent addStudentToKontrolKelas(int idKelas, int nim) {
        KontrolKelas kontrolKelas = kontrolKelasRepository.findByIdKelas(idKelas).orElse(null);
        Student student = studentRepository.findByNim(nim).orElse(null);

        if (kontrolKelas != null && student != null) {
            KontrolKelasStudentId kontrolKelasStudentId = new KontrolKelasStudentId(idKelas,nim);
            KontrolKelasStudent kontrolKelasStudent = new KontrolKelasStudent(kontrolKelasStudentId);
            return kontrolKelasStudentRepository.save(kontrolKelasStudent);
        }

        return null;
    }

    public Optional<KontrolKelasStudent> getStudentsByIdKelas(int kontrolKelas) {
        return kontrolKelasStudentRepository.findByIdKelas(kontrolKelas);
    }
}
