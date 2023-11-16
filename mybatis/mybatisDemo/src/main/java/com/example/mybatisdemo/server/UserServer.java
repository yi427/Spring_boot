package com.example.mybatisdemo.server;

import com.example.mybatisdemo.pojo.user;

public interface UserServer {
    public user findById(Integer id);
}
