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

    public KontrolKelasStudent addStudentToKontrolKelas(int idKelas, int nim , int nilaiAkhir) {
        KontrolKelas kontrolKelas = kontrolKelasRepository.findByIdKelas(idKelas).orElse(null);
        Student student = studentRepository.findByNim(nim).orElse(null);

        if (kontrolKelas != null && student != null) {
            KontrolKelasStudentId kontrolKelasStudentId = new KontrolKelasStudentId(idKelas, nim , nilaiAkhir);
            KontrolKelasStudent kontrolKelasStudent = new KontrolKelasStudent(kontrolKelasStudentId);
            return kontrolKelasStudentRepository.save(kontrolKelasStudent);
        }

        return null;
    }

    public List<KontrolKelasStudent> getStudentsByKontrolKelas(int idKelas) {
        return kontrolKelasStudentRepository.findById_KontrolKelas(idKelas);
    }

    public boolean deleteKontrolKelasStudent(int idKelas, int nim , int nilaiAkhir) {
        KontrolKelasStudentId id = new KontrolKelasStudentId(idKelas, nim , nilaiAkhir);
        Optional<KontrolKelasStudent> existingStudent = kontrolKelasStudentRepository.findById(id);
        if (existingStudent.isPresent()) {
            kontrolKelasStudentRepository.deleteById(id);
            return true;
        }
        return false;
    }

//    public KontrolKelasStudent updateKontrolKelasStudent(int idKelas, int nim, int nilaiAkhir) {
//        KontrolKelasStudent kontrolKelasStudent = kontrolKelasStudentRepository.findByIdKelasAndNim(idKelas, nim);
//        if (kontrolKelasStudent != null) {
//            kontrolKelasStudent.setNilaiAkhir(nilaiAkhir);
//            kontrolKelasStudentRepository.save(kontrolKelasStudent);
//            return kontrolKelasStudent;
//        }
//        return null;
//    }
}