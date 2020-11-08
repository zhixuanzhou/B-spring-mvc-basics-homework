package com.thoughtworks.capacity.gtb.mvc.UserController;
import com.thoughtworks.capacity.gtb.mvc.Exception.InvalidPasswordException;
import com.thoughtworks.capacity.gtb.mvc.Exception.InvalidUserException;
import com.thoughtworks.capacity.gtb.mvc.UserModel.User;
import com.thoughtworks.capacity.gtb.mvc.UserModel.UserRequest;
import com.thoughtworks.capacity.gtb.mvc.UserService.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@RestController
@Validated
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public void registerUser(@RequestBody @Valid UserRequest userRequest) {
        userService.createUser(userRequest);
    }

    @GetMapping("/login")
    public User Login(@RequestParam
                          @NotBlank(message = "username cannot be blank.")
                          @Pattern(regexp="[a-zA-Z0-9_]+", message="only numbers, letters and underscores are allowed for username.")
                          @Size(min=3, max=10, message="the length of username should between 3 and 10.") String username,
                      @RequestParam
                      @NotBlank(message = "password cannot be blank.")
                      @Size(min=5, max=12, message="the length of password should between 5 and 12.") String password) throws InvalidPasswordException, InvalidUserException {
        return userService.loginUser(username, password);
    }
}
