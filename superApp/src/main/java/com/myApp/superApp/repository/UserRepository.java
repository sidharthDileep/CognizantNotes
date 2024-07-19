package com.myApp.superApp.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.myApp.superApp.entity.User;

public interface UserRepository extends JpaRepository<User, Long>{

	Optional<User> findByUsername(String username);

}
