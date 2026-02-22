package com.JWT.demo.Controller;

import com.JWT.demo.Model.RolesList;
import com.JWT.demo.Repository.UserRepo;
import com.JWT.demo.Service.UserService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/")
public class UserController {
    @Autowired
    UserService service;
    @Autowired
    UserRepo repo;
    @PostConstruct
    public void initUsers(){

        service.createUsers();
    }

    @GetMapping("/Users")
    public List<RolesList> getUsers(){
        return repo.findAll();
    }

    @GetMapping("/user")
    @PreAuthorize("/User")
    public String getUserAcess(){
        return "User Access";
    }

    @GetMapping("/admin")
    @PreAuthorize("/Admin")
    public String getAdminAcess(){
        return "Admin Access";
    }
}
