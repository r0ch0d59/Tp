package com.insy2s.users.controllers;


import com.insy2s.users.models.Role;
import com.insy2s.users.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Roles")
public class RoleController {

    @Autowired
    RoleService roleService;

    @PostMapping
 public ResponseEntity<Role> createRole(@RequestBody Role role) {
        Role createdRole = roleService.createRole(role);
        return new ResponseEntity<>(createdRole, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Role>> getRoles() {
        List<Role> getRoles = roleService.getAllRoles();
        return new ResponseEntity<>(getRoles, HttpStatus.OK);
    }

    @PutMapping("/users/{userId}/roles/{roleId}")
    public ResponseEntity<Role> createUserRole(@RequestBody Role role) {
        Role createdRole = roleService.createRole(role);
        return new ResponseEntity<>(createdRole, HttpStatus.CREATED);
    }


}
