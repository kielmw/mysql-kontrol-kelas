package com.example.mysqlkontrolkelas.repository;

import com.example.mysqlkontrolkelas.model.KontrolKelasStudent;
import com.example.mysqlkontrolkelas.model.KontrolKelasStudentId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface KontrolKelasStudentRepository extends JpaRepository<KontrolKelasStudent, KontrolKelasStudentId> {
    Optional<KontrolKelasStudent> findByIdKelas(int kontrolKelas);
}
