package com.thoughtworks.capacity.gtb.mvc.UserController;
import com.thoughtworks.capacity.gtb.mvc.UserModel.UserRequest;
import com.thoughtworks.capacity.gtb.mvc.UserService.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import javax.validation.Valid;

@RestController
@Validated
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping ("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public void registerUser (@RequestBody @Valid UserRequest userRequest) {
        userService.createUser(userRequest);
    }
}
