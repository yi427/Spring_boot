package com.example.mybatisdemo.pojo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class user {
    public user(int id, String name, int age, int gender, String phone) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.phone = phone;
    }
    private int id;
    private String name;
    private int age;
    private int gender;
    private String phone;
}
