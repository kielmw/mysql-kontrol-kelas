package com.example.mysqlkontrolkelas.repository;

import com.example.mysqlkontrolkelas.model.KontrolKelasStudent;
import com.example.mysqlkontrolkelas.model.KontrolKelasStudentId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface KontrolKelasStudentRepository extends JpaRepository<KontrolKelasStudent, KontrolKelasStudentId> {
    List<KontrolKelasStudent> findById_KontrolKelas(int kontrolKelas);
}