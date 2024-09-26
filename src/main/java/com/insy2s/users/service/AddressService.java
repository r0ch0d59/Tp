package com.insy2s.users.service;


import com.insy2s.users.models.Address;
import com.insy2s.users.models.User;
import com.insy2s.users.repositories.IAddressRepository;
import com.insy2s.users.repositories.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Service




public class AddressService {

    @Autowired

    private IAddressRepository addressRepository;

    @Autowired
    private IUserRepository userRepository;

    public Address createAddress(Address address) {

        return address;


    }
    public Address updateAddress(Long Id,Address address) {
        Address address1 = addressRepository.findById(Id).orElse(null);

        if (address1 != null) {
            address1.setStreetNumber(address1.getStreetNumber());
            address1.setStreetName(address1.getStreetName());
            address1.setZipCode(address1.getZipCode());
            address1.setCity(address1.getCity());


            return addressRepository.save(address1);
        }
        return address;
    }

    public boolean deleteAddress(Long Id) {
        Address address = addressRepository.findById(Id).orElse(null);
        if (address != null) {
            List<User> usersUsingAddress = userRepository.findByAddress_Id(Id);
            if (usersUsingAddress.isEmpty()) {
                addressRepository.delete(address);
                return true;
            }

        }else {
            return false;
        }return false;

    }
    public List<Address> getAllAddress() {

        return addressRepository.findAll();
    }



}
