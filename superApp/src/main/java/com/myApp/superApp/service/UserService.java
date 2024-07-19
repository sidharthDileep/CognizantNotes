package com.myApp.superApp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.myApp.superApp.entity.User;
import com.myApp.superApp.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	public List<User> getAllUsers(){
		return userRepository.findAll();
	}
	
	public User getUserById(Long id) {
		return userRepository.findById(id).orElse(null);
	}
	
	public User createUser(User user) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		return userRepository.save(user);
	}
	
	public User updateUser(Long id, User userDetails) {
		User user = userRepository.findById(id).orElse(null);
		if(user != null) {
			user.setUsername(userDetails.getUsername());
			user.setPassword(passwordEncoder.encode(userDetails.getPassword()));
			user.setEmail(userDetails.getEmail());
			return userRepository.save(user);
		}
		
		return null;
	}

	public void deleteUser(Long id) {
		userRepository.deleteById(id);
	}

}
