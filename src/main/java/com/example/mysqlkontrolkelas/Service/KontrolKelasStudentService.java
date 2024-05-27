package com.example.mysqlkontrolkelas.Service;

import com.example.mysqlkontrolkelas.model.*;
import com.example.mysqlkontrolkelas.repository.KontrolKelasRepository;
import com.example.mysqlkontrolkelas.repository.KontrolKelasStudentRepository;
import com.example.mysqlkontrolkelas.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
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
            KontrolKelasStudentId kontrolKelasStudentId = new KontrolKelasStudentId(idKelas, nim);
            KontrolKelasStudent kontrolKelasStudent = new KontrolKelasStudent(kontrolKelasStudentId);
            return kontrolKelasStudentRepository.save(kontrolKelasStudent);
        }

        return null;
    }

    public List<KontrolKelasStudent> getStudentsByKontrolKelas(int idKelas) {
        return kontrolKelasStudentRepository.findById_KontrolKelas(idKelas);
    }

    public boolean deleteKontrolKelasStudent(int idKelas, int nim) {
        KontrolKelasStudentId id = new KontrolKelasStudentId(idKelas, nim);
        Optional<KontrolKelasStudent> existingStudent = kontrolKelasStudentRepository.findById(id);
        if (existingStudent.isPresent()) {
            kontrolKelasStudentRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
