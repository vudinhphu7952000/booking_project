package com.booking.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.booking.entity.User;

public interface UserRepository extends JpaRepository<User, Integer>{
	User findOneByUsername(String username);

}
