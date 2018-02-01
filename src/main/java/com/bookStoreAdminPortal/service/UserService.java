package com.bookStoreAdminPortal.service;

import java.util.Set;

import com.bookStoreAdminPortal.domain.User;
import com.bookStoreAdminPortal.security.domain.UserRole;



public interface UserService {
	User createUser(User user,Set<UserRole> userRole);
	User save(User user);
}
