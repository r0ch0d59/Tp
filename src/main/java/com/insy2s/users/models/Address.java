package com.insy2s.users.models;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;




@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="address")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Address_GEN")
    @SequenceGenerator(name = "Address_GEN", sequenceName = "Address_SEQ", initialValue = 1000)
    private Long id;
    @Column(name = "street_number")
    private String streetNumber;
    @Column(name = "street_name")
    private String streetName;
    @Column(name = "zip_code")
    private String zipCode;
    private String city;


    @OneToMany(mappedBy = "address")
    @JsonIgnore
    private List<User> users=new ArrayList<>();



}
