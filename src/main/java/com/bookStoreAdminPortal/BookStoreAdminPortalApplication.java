package com.bookStoreAdminPortal;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.bookStoreAdminPortal.domain.User;
import com.bookStoreAdminPortal.security.domain.Role;
import com.bookStoreAdminPortal.security.domain.UserRole;
import com.bookStoreAdminPortal.service.UserService;
import com.bookStoreAdminPortal.serviceUtility.SecurityUtility;

@SpringBootApplication
public class BookStoreAdminPortalApplication implements CommandLineRunner {

	

	@Autowired
	private UserService userService;


	public static void main(String[] args) {
		SpringApplication.run(BookStoreAdminPortalApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		User user1 = new User();
		user1.setUsername("admin");
		user1.setPassword(SecurityUtility.passwordEncoder().encode("admin"));
		user1.setEmail("admin@gmail.com");
		
		Set<UserRole> userRoles = new HashSet<>();
		
		Role role1= new Role();
		role1.setRoleId(0);
		role1.setName("ROLE_ADMIN");
		
		userRoles.add(new UserRole(user1, role1));
		userService.createUser(user1, userRoles);

	}
}
