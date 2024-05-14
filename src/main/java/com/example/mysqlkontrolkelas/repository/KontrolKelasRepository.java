package com.example.mysqlkontrolkelas.repository;

import com.example.mysqlkontrolkelas.model.KontrolKelas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface KontrolKelasRepository extends JpaRepository<KontrolKelas, Integer> {
    Optional<KontrolKelas> findByIdKelas(int id_kelas);
}

