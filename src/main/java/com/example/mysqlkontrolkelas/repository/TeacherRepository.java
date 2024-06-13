package com.example.mysqlkontrolkelas.repository;

import com.example.mysqlkontrolkelas.model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Long> {
    Optional<Teacher> findByNip(int nip);
}
