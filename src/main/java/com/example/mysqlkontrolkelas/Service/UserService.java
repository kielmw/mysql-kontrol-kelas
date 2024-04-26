package com.example.mysqlkontrolkelas.Service;

import com.example.mysqlkontrolkelas.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service()
public class UserService {

    User findBymemberID(Long memberID);

    User findByemailId(String emailId);

    User save(User user);

    User addMember(User user);

    List<User> findAll();
}
