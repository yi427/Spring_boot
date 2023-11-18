package com.example.coursetrackerapplication.entity;

import com.example.coursetrackerapplication.utility.Password;
import lombok.Getter;

@Getter
public class User {
    @Password
    private String password;

    private final String userName;
    public User(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }
}
