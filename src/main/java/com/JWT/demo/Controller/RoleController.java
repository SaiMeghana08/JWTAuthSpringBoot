package com.JWT.demo.Controller;

import com.JWT.demo.Model.Role;
import com.JWT.demo.Service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RoleController {
    @Autowired
    RoleService service;
    @PostMapping("/createRole")
    public Role createRole(@RequestBody Role role){
        return service.createRole(role);
    }
}
