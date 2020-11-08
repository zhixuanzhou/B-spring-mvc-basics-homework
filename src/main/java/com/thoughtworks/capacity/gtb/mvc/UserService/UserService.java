package com.thoughtworks.capacity.gtb.mvc.UserService;

import com.thoughtworks.capacity.gtb.mvc.Exception.DuplicateUserNameException;
import com.thoughtworks.capacity.gtb.mvc.UserModel.User;
import com.thoughtworks.capacity.gtb.mvc.UserModel.UserRequest;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserService {
    private final Map<String, User> userList = new HashMap<>();

    public UserService() {
    }

    public void createUser(UserRequest userRequest) throws DuplicateUserNameException {
        if(userList.containsKey(userRequest.getUsername())) {
           throw new DuplicateUserNameException("This user alr exists");
        }
        User newUser = new User(userRequest.getEmail(), userRequest.getPassword(), userRequest.getEmail());
        this.userList.put(newUser.getUsername(), newUser);
    }
}
