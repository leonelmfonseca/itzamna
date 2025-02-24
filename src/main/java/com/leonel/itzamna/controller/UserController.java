package com.leonel.itzamna.controller;

import com.leonel.itzamna.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class UserController {
    
    UserService userService;
    
    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

}
