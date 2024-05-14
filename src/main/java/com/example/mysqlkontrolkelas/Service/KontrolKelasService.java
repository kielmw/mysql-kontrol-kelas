package com.example.mysqlkontrolkelas.Service;
import com.example.mysqlkontrolkelas.model.KontrolKelas;
import com.example.mysqlkontrolkelas.repository.KontrolKelasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
