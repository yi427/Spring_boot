package com.example.mybatisdemo.controller;

import com.example.mybatisdemo.pojo.user;
import com.example.mybatisdemo.server.UserServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    private UserServer server;
    @RequestMapping("findById")
    public user findById(Integer id) {
        return server.findById(id);
    }
}
