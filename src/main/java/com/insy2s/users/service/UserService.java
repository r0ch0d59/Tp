package com.insy2s.users.service;


import com.insy2s.users.models.Address;
import com.insy2s.users.models.User;
import com.insy2s.users.repositories.IAddressRepository;
import com.insy2s.users.repositories.IUserRepository;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Service


public class UserService {


    @Autowired
    private IUserRepository userRepository;


    @Autowired
    private IAddressRepository addressRepository;

    public User assignAddressToUser(Long userId, Long addressId) {
        Address assigneAddress = addressRepository.findById(addressId).get();
        User assigneUser = userRepository.findById(userId).get();

        assigneUser.setAddress(assigneAddress);

        return userRepository.save(assigneUser);
    }

    public List<User> getUsersByAddress(Long addressId) {


        return userRepository.findByAddress_Id(addressId);



    }


    public User createUser(User user) {
        return userRepository.save(user);
    }

    public User updateUser(Long id, User user) {
        User user1 = userRepository.findById(id).orElse(null);

        if (user1 != null) {
            user1.setFirstName(user.getFirstName());
            user1.setLastName(user.getLastName());
            user1.setEmail(user.getEmail());


            return userRepository.save(user1);
        }
        return user;


    }

    public void deleteUser(Long id) {
        User user = userRepository.findById(id).orElse(null);
        if (user != null) {
            userRepository.delete(user);
        }

    }

    public List<User> getUsers() {
        return userRepository.findAll();
    }


    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);

    }

    public User removeRoleFromUser(Long userId, Long roleId) {
        User user = userRepository.findById(userId).orElse(null);
        if (user != null) {
            user.getRoles().remove(roleId);
            return userRepository.save(user);
        } else {
            return null;
        }

    }

        public User getUserRoles (Long userId) {
            return userRepository.findById(userId).orElse(null);
        }

    }



