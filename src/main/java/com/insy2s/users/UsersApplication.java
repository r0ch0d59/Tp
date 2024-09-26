package com.insy2s.users;

import com.insy2s.users.models.Address;
import com.insy2s.users.models.Role;
import com.insy2s.users.models.User;
import com.insy2s.users.repositories.IAddressRepository;
import com.insy2s.users.repositories.IRoleRepository;
import com.insy2s.users.repositories.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class UsersApplication implements CommandLineRunner {


	@Autowired
	private IUserRepository userRepository;
	@Autowired
	private IAddressRepository addressRepository;
	@Autowired
	private IRoleRepository roleRepository;

	public static void main(String[] args) {
		SpringApplication.run(UsersApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// Création des rôles
		Role adminRole = new Role();
		adminRole.setName("ADMIN");
		roleRepository.save(adminRole);
		Role userRole = new Role();
		userRole.setName("USER");
		roleRepository.save(userRole);
		// Création des adresses
		Address address1 = new Address();
		address1.setStreetNumber("123");
		address1.setStreetName("Main Street");
		address1.setCity("Springfield");
		address1.setZipCode("12345");
		addressRepository.save(address1);

		Address address2 = new Address();
		address2.setStreetNumber("456");
		address2.setStreetName("Broadway");
		address2.setCity("Metropolis");
		address2.setZipCode("67890");
		addressRepository.save(address2);

		// Création des utilisateurs
		User user1 = new User();
		user1.setFirstName("John");
		user1.setLastName("Doe");
		user1.setEmail("john.doe@example.com");
		user1.setAddress(address1);
		user1.setRoles(Arrays.asList(adminRole, userRole)); // Association des rôles
		userRepository.save(user1);

		User user2 = new User();
		user2.setFirstName("Jane");
		user2.setLastName("Doe");
		user2.setEmail("jane.doe@example.com");
		user2.setAddress(address2);
		user2.setRoles(List.of(userRole)); // Association d'un seul rôle
		userRepository.save(user2);
	}

}
