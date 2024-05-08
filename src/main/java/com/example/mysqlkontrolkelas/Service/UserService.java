package com.example.mysqlkontrolkelas.Service;

import com.example.mysqlkontrolkelas.model.User;
import org.springframework.stereotype.Service;
import com.example.mysqlkontrolkelas.repository.UserRepo;
import java.util.Date;
import java.util.List;

@Service
public class UserService {

    private final UserRepo userRepository;

    // Injecting userRepository via constructor
    public UserService(UserRepo userRepository) {
        this.userRepository = userRepository;
    }

    public User addMember(User user) {
        user.setId(user.getId());
        user.setName(user.getName());
        user.setEmailId(user.getEmailId());
//        user.setCreatedAt(new Date());
//        user.setUpdatedAt(new Date());
        return userRepository.save(user);
    }

}
