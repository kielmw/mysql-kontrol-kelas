package com.example.mysqlkontrolkelas.Service;
import com.example.mysqlkontrolkelas.model.KontrolKelas;
import com.example.mysqlkontrolkelas.repository.KontrolKelasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KontrolKelasService {

    @Autowired
    private KontrolKelasRepository kontrolKelasRepository;

    public KontrolKelas saveKontrolKelas(KontrolKelas kontrolKelas) {
        return kontrolKelasRepository.save(kontrolKelas);
    }
    public KontrolKelas findKontrolKelasByIdKelas(int idKelas) {
        return kontrolKelasRepository.findByIdKelas(idKelas).orElse(null);
    }
    public List<KontrolKelas> findAllKontrolKelas() {
        return kontrolKelasRepository.findAll();
    }


    @Transactional
    public KontrolKelas updateKontrolKelas(int idKelas, KontrolKelas updatedKontrolKelas) {
        KontrolKelas existingKontrolKelas = kontrolKelasRepository.findByIdKelas(idKelas).orElse(null);
        if (existingKontrolKelas != null) {
            existingKontrolKelas.setNamaKelas(updatedKontrolKelas.getNamaKelas());
            existingKontrolKelas.setDeskripsiKelas(updatedKontrolKelas.getDeskripsiKelas());
            existingKontrolKelas.setIdEvaluasi(updatedKontrolKelas.getIdEvaluasi());
            existingKontrolKelas.setProgressEvaluasi(updatedKontrolKelas.getProgressEvaluasi());
            existingKontrolKelas.setIdGuru(updatedKontrolKelas.getIdGuru());
            existingKontrolKelas.setNamaGuru(updatedKontrolKelas.getNamaGuru());
            existingKontrolKelas.setKontrolKelasStudents(updatedKontrolKelas.getKontrolKelasStudents());
            return kontrolKelasRepository.save(existingKontrolKelas);
        }
        return null;
    }
    public boolean deleteKontrolKelasByIdKelas(int idKelas) {
        if (kontrolKelasRepository.existsById(idKelas)) {
            kontrolKelasRepository.deleteById(idKelas);
            return true;
        }
        return false;
    }
}
