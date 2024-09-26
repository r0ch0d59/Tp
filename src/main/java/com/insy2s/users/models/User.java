package com.insy2s.users.models;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;




@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_sequence")
    @SequenceGenerator(name = "user sequence", allocationSize = 1, initialValue = 1000)
    private int id;
    private String firstName;
    private String lastName;
    private String email;


    @ManyToOne
    @JoinColumn(name = "address_id")
    private Address address;

    @ManyToMany

    private List<Role> roles = new ArrayList<>();


}
