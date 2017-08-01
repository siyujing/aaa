package com.example.demo.utils;

import lombok.Data;

import java.util.List;

/**
 * Created by boxfish on 17/7/7.
 */
@Data
public class User {
    String userName;
    int Age;
    String sex;
    List<String> friends;

    public User(String userName, int age) {
        this.userName = userName;
        Age = age;
    }

    public User(String userName, int age, List<String> friends) {
        this.userName = userName;
        Age = age;
        this.friends = friends;
    }

    public User() {
    }
}
