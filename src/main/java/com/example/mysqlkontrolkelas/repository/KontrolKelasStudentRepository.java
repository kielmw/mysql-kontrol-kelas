package com.example.mysqlkontrolkelas.repository;

import com.example.mysqlkontrolkelas.model.KontrolKelasStudent;
import com.example.mysqlkontrolkelas.model.KontrolKelasStudentId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KontrolKelasStudentRepository extends JpaRepository<KontrolKelasStudent, KontrolKelasStudentId> {
}
