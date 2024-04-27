package com.tantely.routerover.controllers;

import com.tantely.routerover.dtos.UserResponse;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/users")
public class UserController {

    @GetMapping
    public List<UserResponse> getAllUsers() {
        return List.of(new UserResponse());
    }
}
