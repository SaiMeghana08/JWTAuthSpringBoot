package com.JWT.demo.Controller;

import com.JWT.demo.Service.UserService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class UserController {
    @Autowired
    UserService service;

    @PostConstruct
    public void initUsers(){

        service.createUsers();
    }
}
