package com.insy2s.users.controllers;


import com.insy2s.users.models.Address;
import com.insy2s.users.models.User;
import com.insy2s.users.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/addresses")
public class AddressController {

    @Autowired
    private AddressService addressService;

    @PostMapping
    public ResponseEntity<Address> createAddress(@RequestBody Address address) {
        Address createdAddress = addressService.createAddress(address);

        return new ResponseEntity<>(createdAddress, HttpStatus.CREATED);

    }

    @PutMapping
    public ResponseEntity<Address> updateAddress(@PathVariable Long Id,@RequestBody Address address) {
        Address updateAddress= addressService.updateAddress(Id, address);
        return new ResponseEntity<>(updateAddress, HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteAddress(@PathVariable Long id) {
        boolean isDeleted = addressService.deleteAddress(id);
        if (isDeleted) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        }
    }

    @GetMapping
    public ResponseEntity<List<Address>> getAllAddresses() {
        List<Address> getAllAddress = addressService.getAllAddress();
        return new ResponseEntity<>(getAllAddress, HttpStatus.OK);

    }



    }






