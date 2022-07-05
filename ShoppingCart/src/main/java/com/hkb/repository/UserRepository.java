package com.hkb.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hkb.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	
	Optional<User>findUserByemail(String email);
}
