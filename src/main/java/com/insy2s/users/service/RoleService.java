package com.insy2s.users.service;


import com.insy2s.users.models.Role;
import com.insy2s.users.models.User;
import com.insy2s.users.repositories.IRoleRepository;
import com.insy2s.users.repositories.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.management.relation.RoleNotFoundException;
import java.util.List;
import java.util.Optional;





@Service
@RequestMapping("/Role")
public class RoleService {

    @Autowired
    private IRoleRepository roleRepository;

    @Autowired
    private IUserRepository userRepository;


    public Role createRole(Role role) {

        return roleRepository.save(role);


    }

    public List<Role> getAllRoles(){
        return roleRepository.findAll();
    }

    public Role addRoleToUser(Long userId, Long roleId) {

        Optional<Role> roleOpt = roleRepository.findById(roleId);
        Optional<User> userOpt = userRepository.findById(userId);

        if(roleOpt.isPresent() && userOpt.isPresent()) {
            Role role = roleOpt.get();
            User user = userOpt.get();

            user.getRoles().add(role);
            roleRepository.save(role);
            userRepository.save(user);
            return role;



        }else {
            return null;
        }

    }


}




