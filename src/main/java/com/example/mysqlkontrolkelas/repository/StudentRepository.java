package com.example.mysqlkontrolkelas.repository;

import com.example.mysqlkontrolkelas.model.KontrolKelas;
import com.example.mysqlkontrolkelas.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
    Optional<Student> findByNim(int nim);
}
