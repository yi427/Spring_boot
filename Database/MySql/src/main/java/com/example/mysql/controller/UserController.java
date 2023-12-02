package com.example.mysql.controller;

import com.example.mysql.entity.User;
import com.example.mysql.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@CrossOrigin
public class UserController {
    @Autowired
    private UserRepository user;

    @RequestMapping("findById")
    public Optional<User> findById(Integer id) {
        return user.findById(id);
    }

    @RequestMapping("all")
    public Iterable<User> all() {
        return user.findAll();
    }
}
