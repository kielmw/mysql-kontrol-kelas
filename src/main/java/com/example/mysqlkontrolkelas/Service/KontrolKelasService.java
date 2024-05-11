package com.example.mysqlkontrolkelas.Service;

import com.example.mysqlkontrolkelas.model.KontrolKelas;
import com.example.mysqlkontrolkelas.repository.KontrolKelasRepository;
import com.example.mysqlkontrolkelas.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import java.util.Optional;
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
        Optional<KontrolKelas> kontrolKelasOptional = Optional.ofNullable(kontrolKelasRepository.findById(idKelas));

        if (kontrolKelasOptional.isPresent()) {
            KontrolKelas existingKontrolKelas = kontrolKelasOptional.get();

            // Update KontrolKelas fields
            existingKontrolKelas.setNamaKelas(updatedKontrolKelas.getNamaKelas());
            existingKontrolKelas.setIdEvaluasi(updatedKontrolKelas.getIdEvaluasi());
            existingKontrolKelas.setProgressEvaluasi(updatedKontrolKelas.getProgressEvaluasi());
            // Update other fields as needed

            // Delete existing students associated with the same idKelas
            existingKontrolKelas.getStudents().clear();

            // Add updated students
            List<Student> updatedStudents = new ArrayList<>();
            for (Student updatedStudent : updatedKontrolKelas.getStudents()) {
                updatedStudent.setKontrolKelas(existingKontrolKelas);
                updatedStudents.add(updatedStudent);
            }
            existingKontrolKelas.setStudents(updatedStudents);

            // Save the updated KontrolKelas
            return kontrolKelasRepository.save(existingKontrolKelas);
        } else {
            // Handle the case where the idKelas is not found
            throw new IllegalArgumentException("KontrolKelas with id " + idKelas + " not found");
        }
    }

    public Optional<KontrolKelas> findKontrolKelasById(int idKelas) {
        return Optional.ofNullable(kontrolKelasRepository.findById(idKelas));
    }
}