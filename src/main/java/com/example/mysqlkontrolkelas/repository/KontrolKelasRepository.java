package com.example.mysqlkontrolkelas.repository;

import com.example.mysqlkontrolkelas.model.KontrolKelas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface KontrolKelasRepository extends JpaRepository<KontrolKelas, Integer> {

    // Method to find KontrolKelas by idKelas
    KontrolKelas findByIdKelas(int idKelas);
    Optional<KontrolKelas> findById(int idKelas);

}

