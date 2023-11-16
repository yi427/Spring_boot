package com.example.mybatisdemo.server.impl;

import com.example.mybatisdemo.mapper.UserMapper;
import com.example.mybatisdemo.pojo.user;
import com.example.mybatisdemo.server.UserServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServerImpl implements UserServer {
    @Autowired
    private UserMapper userMapper;
    @Override
    public user findById(Integer id) {
        return userMapper.findById(id);
    }
}
