package com.leonel.itzamna.controller;

import com.leonel.itzamna.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.RequestEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
// QUESTION: @Annotation RequestMapping here
@RequestMapping
public class UserController {
    
    UserService userService;
    
    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

}
