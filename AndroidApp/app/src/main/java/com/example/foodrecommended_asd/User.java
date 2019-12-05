package com.example.foodrecommended_asd;

public class User {
    private String userEmail;
    private String password;
    private String name;

    public User(String userEmail, String password, String name) {
        this.userEmail = userEmail;
        this.password = password;
        this.name = name;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }
}
