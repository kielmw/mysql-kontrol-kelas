package com.example.mysqlkontrolkelas.repository;

import com.example.mysqlkontrolkelas.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {
    // You can define additional query methods here if needed
}
