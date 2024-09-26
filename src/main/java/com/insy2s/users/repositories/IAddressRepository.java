package com.insy2s.users.repositories;


import com.insy2s.users.models.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IAddressRepository extends JpaRepository<Address, Long> {


    @Query("select a from Address a where a.streetNumber =?1 and a.streetName =?2 and a.city =?3")
    Optional<Address> findAddress(String streetNumber, String streetName);




}
