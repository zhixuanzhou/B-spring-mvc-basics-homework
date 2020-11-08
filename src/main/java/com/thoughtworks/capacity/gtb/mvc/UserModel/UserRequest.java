package com.thoughtworks.capacity.gtb.mvc.UserModel;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class UserRequest {

    public Integer id;

    @NotBlank(message = "username cannot be blank.")
    @Pattern(regexp="[a-zA-Z0-9_]+", message="only numbers, letters and underscores are allowed for username.")
    @Size(min=3, max=10, message="the length of username should between 3 and 10.")
    public String username;

    @NotBlank(message = "password cannot be blank.")
    @Size(min=5, max=12, message="the length of password should between 5 and 12.")
    public String password;

    @Email(message="should provide valid email format.")
    public String email;

    public UserRequest(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }
}
