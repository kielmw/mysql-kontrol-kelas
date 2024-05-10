package com.example.mysqlkontrolkelas.Service;

import com.example.mysqlkontrolkelas.model.KontrolKelas;
import com.example.mysqlkontrolkelas.model.Student;
import com.example.mysqlkontrolkelas.repository.KontrolKelasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

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

    public KontrolKelas updateKontrolKelas(int idKelas, KontrolKelas updatedKontrolKelas) {
        Optional<KontrolKelas> existingKontrolKelasOptional = Optional.ofNullable(kontrolKelasRepository.findByIdKelas(idKelas));

        if (existingKontrolKelasOptional.isPresent()) {
            KontrolKelas existingKontrolKelas = existingKontrolKelasOptional.get();

            // Update KontrolKelas fields
            existingKontrolKelas.setNamaKelas(updatedKontrolKelas.getNamaKelas());
            existingKontrolKelas.setIdEvaluasi(updatedKontrolKelas.getIdEvaluasi());
            existingKontrolKelas.setProgressEvaluasi(updatedKontrolKelas.getProgressEvaluasi());
            // Update other fields as needed

            // Clear existing students
            existingKontrolKelas.getStudents().clear();

            // Add updated students
            for (Student student : updatedKontrolKelas.getStudents()) {
                student.setKontrolKelas(existingKontrolKelas);
                existingKontrolKelas.getStudents().add(student);
            }

            return kontrolKelasRepository.save(existingKontrolKelas);
        } else {
            throw new IllegalArgumentException("KontrolKelas with id " + idKelas + " not found");
        }
    }
}
