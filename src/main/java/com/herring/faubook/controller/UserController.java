package com.herring.faubook.controller;

import com.herring.faubook.entity.UserEntity;
import com.herring.faubook.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/services/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/all")
    public List<UserEntity> getAll() {
        return userService.findAllUsers();
    }

    @PostMapping("/new")
    public void newUser(@RequestBody UserEntity user) {
        userService.saveUser(user);
    }
}
