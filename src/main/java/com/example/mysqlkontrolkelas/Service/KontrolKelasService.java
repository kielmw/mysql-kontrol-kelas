package com.example.mysqlkontrolkelas.Service;

import com.example.mysqlkontrolkelas.model.KontrolKelas;
import com.example.mysqlkontrolkelas.repository.KontrolKelasRepository;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class KontrolKelasService {

    private final KontrolKelasRepository kontrolKelasRepository;

    public KontrolKelas addKontrolKelas(KontrolKelas kontrolKelas) {
        // Log user object here
        System.out.println("Received user object: " + kontrolKelas);
        return kontrolKelasRepository.save(kontrolKelas);
    }

    public Iterable<KontrolKelas> getAllKontrolKelas() {
        return kontrolKelasRepository.findAll();
    }

    public KontrolKelas updateKontrolKelas(int idKelas, KontrolKelas updatedKontrolKelas) {
        Optional<KontrolKelas> kontrolKelasOptional = kontrolKelasRepository.findById((long) idKelas);

        if (kontrolKelasOptional.isPresent()) {
            KontrolKelas existingKontrolKelas = kontrolKelasOptional.get();
            existingKontrolKelas.setNim(updatedKontrolKelas.getNim());
            existingKontrolKelas.setNama(updatedKontrolKelas.getNama());
            existingKontrolKelas.setRole(updatedKontrolKelas.getRole());
            existingKontrolKelas.setNamaKelas(updatedKontrolKelas.getNamaKelas());
            // Set other fields as needed

            return kontrolKelasRepository.save(existingKontrolKelas);
        } else {
            // Handle the case where the idKelas is not found
            return null;
        }
    }
}
