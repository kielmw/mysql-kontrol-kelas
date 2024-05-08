package com.example.mysqlkontrolkelas.Service;

import com.example.mysqlkontrolkelas.model.User;
import com.example.mysqlkontrolkelas.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepo userRepository;

    public User addUser(User user) {
        // Log user object here
        System.out.println("Received user object: " + user);
        return userRepository.save(user);
    }


    public Iterable<User> getAllUsers() {
        return userRepository.findAll();
    }
}
