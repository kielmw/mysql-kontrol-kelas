package com.example.mysqlkontrolkelas.controller;

import com.example.mysqlkontrolkelas.Service.UserService;
import com.example.mysqlkontrolkelas.model.User;
import com.example.mysqlkontrolkelas.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/")
@Controller
public class UserController {
    @Autowired
    UserRepo userRepo;
    @Autowired
    UserService userService;

    @GetMapping("/users")
    public List<User> getAllUser() {
        return userRepo.findAll();
    }

    @PostMapping("/create")
    public User createMember(@RequestBody User user) {
        user.setCreatedAt(new Date());
        user.setUpdatedAt(new Date());
        return userRepo.save(user);
    }

    @PostMapping("/addMember")
    public User addMember(@RequestBody User user) {
        return userService.addMember(user);
    }
}