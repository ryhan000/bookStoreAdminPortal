package com.bookStoreAdminPortal.repository;

import org.springframework.data.repository.CrudRepository;

import com.bookStoreAdminPortal.domain.User;



public interface UserRepository extends CrudRepository <User,Long >{
    User findByUsername(String username);
}
