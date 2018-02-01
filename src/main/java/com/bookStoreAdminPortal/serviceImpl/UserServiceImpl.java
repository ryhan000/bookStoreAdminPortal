package com.bookStoreAdminPortal.serviceImpl;

import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookStoreAdminPortal.domain.User;
import com.bookStoreAdminPortal.repository.RoleRepository;
import com.bookStoreAdminPortal.repository.UserRepository;
import com.bookStoreAdminPortal.security.domain.UserRole;
import com.bookStoreAdminPortal.service.UserService;

@Service
public class UserServiceImpl  implements UserService{

	private static final Logger LOG=LoggerFactory.getLogger(UserService.class);
	
	@Autowired
	private RoleRepository roleRepository;
	
	
	@Autowired
	private UserRepository userRepository;
	
	
	@Override
	public User createUser(User user, Set<UserRole> userRoles) {
		// TODO Auto-generated method stub
		User localUser =userRepository.findByUsername(user.getUsername());
		
		if(localUser !=null) {
			LOG.info("user {} allredy exists.Nothing will be done",user.getUsername());
		}else {
			
			for(UserRole ur:userRoles) {
				roleRepository.save(ur.getRole());
			}
			
			user.getUserRoles().addAll(userRoles);
			localUser= userRepository.save(user);
			
		}
		return localUser;
	}

	@Override
	public User save(User user) {
		// TODO Auto-generated method stub
		return userRepository.save(user);
		
		
	}

}
