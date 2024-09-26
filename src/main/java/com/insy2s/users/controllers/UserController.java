package com.insy2s.users.controllers;


import com.insy2s.users.models.Role;
import com.insy2s.users.models.User;
import com.insy2s.users.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User createdUser = userService.createUser(user);

        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User user) {
        User updatedUser = userService.updateUser(id, user);
        return new ResponseEntity<>(updatedUser, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }

    @GetMapping
    public ResponseEntity<List<User>> getUsers() {
        List<User> getUser = userService.getUsers();
        return new ResponseEntity<>(getUser, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        User getedUser = userService.getUserById(id);
        return new ResponseEntity<>(getedUser, HttpStatus.OK);
    }

    @PutMapping("/{userId}/address/{addressId}")
    public ResponseEntity<User> updateUserAddress(@PathVariable Long userId, @PathVariable Long addressId) {

        User addressUpdate = userService.assignAddressToUser(userId, addressId);

        return new ResponseEntity<>(addressUpdate, HttpStatus.OK);
    }

    @GetMapping(" /addresses/{addressId}/users")
    public ResponseEntity<List<User>> getUsersByAddressId(@PathVariable Long addressId) {
        List<User> getUsers = userService.getUsersByAddress(addressId);
        return new ResponseEntity<>(getUsers, HttpStatus.OK);
    }

    @DeleteMapping("/{userId}/roles/{roleId}")
    public ResponseEntity<Void> deleteUserRole(@PathVariable Long userId, @PathVariable Long roleId) {
        User user = userService.removeRoleFromUser(userId, roleId);
        if (user != null) {
            return ResponseEntity.noContent().build(); // 204 No Content
        } else {
            return ResponseEntity.notFound().build(); // 404 Not Found si l'utilisateur n'existe pas
        }


    }

    @GetMapping("/{userId}/roles")
    public ResponseEntity<List<Role>> getUserRoles(@PathVariable Long userId) {
        List<Role> roles = userService.getUserRoles(userId).getRoles();
        if (roles != null) {
            return new ResponseEntity<>(roles, HttpStatus.OK); // 200 OK
        } else {
            return ResponseEntity.notFound().build(); // 404 Not Found si l'utilisateur n'existe pas
        }
    }
}
