package com.insy2s.users.repositories;


import com.insy2s.users.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IUserRepository extends JpaRepository<User, Long> {

    List<User> findByAddress_Id(Long id);
}
