package com.example.mysqlkontrolkelas.Service;

import com.example.mysqlkontrolkelas.model.KontrolKelas;
import com.example.mysqlkontrolkelas.model.Student;
import com.example.mysqlkontrolkelas.repository.KontrolKelasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KontrolKelasService {

    private final KontrolKelasRepository kontrolKelasRepository;

    @Autowired
    public KontrolKelasService(KontrolKelasRepository kontrolKelasRepository) {
        this.kontrolKelasRepository = kontrolKelasRepository;
    }

    public KontrolKelas addKontrolKelas(KontrolKelas request) {
        KontrolKelas kontrolKelas = new KontrolKelas();
        kontrolKelas.setNamaKelas(request.getNamaKelas());
        kontrolKelas.setIdEvaluasi(request.getIdEvaluasi());
        kontrolKelas.setProgressEvaluasi(request.getProgressEvaluasi());
        for (Student studentRequest : request.getStudents()) {
            Student student = new Student();
            student.setNim(studentRequest.getNim());
            student.setNama(studentRequest.getNama());
            student.setKontrolKelas(kontrolKelas);
            kontrolKelas.getStudents().add(student);
        }

        return kontrolKelasRepository.save(kontrolKelas);
    }
}
