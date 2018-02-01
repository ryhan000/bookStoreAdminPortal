package com.bookStoreAdminPortal.repository;

import org.springframework.data.repository.CrudRepository;

import com.bookStoreAdminPortal.security.domain.Role;

public interface RoleRepository extends CrudRepository<Role, Long>{

	Role findByname(String name);
	
}
