package com.thoughtworks.capacity.gtb.mvc.UserModel;

public class User {

    public final String username;
    public final String password;
    public final String email;

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public User(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }
}
