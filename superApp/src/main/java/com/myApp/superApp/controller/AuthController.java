package com.myApp.superApp.controller;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myApp.superApp.config.JwtService;
import com.myApp.superApp.entity.Role;
import com.myApp.superApp.entity.RoleName;
import com.myApp.superApp.entity.User;
import com.myApp.superApp.repository.RoleRepository;
import com.myApp.superApp.repository.UserRepository;
import com.myApp.superApp.service.UserService;

@RestController
@RequestMapping("api/v1/auth")
public class AuthController {
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private JwtService jwtService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RoleRepository roleRepository;
	
	@PostMapping("/login")
	public String login(@RequestBody User user) {
		
		return jwtService.generateToken(user);
	}
	
	@PostMapping("/register")
	public User register(@RequestBody User user) {
		Set<Role> roles = new HashSet<>();
		Role userRole = roleRepository.findByName(RoleName.ROLE_USER).orElseThrow(
				() -> new RuntimeException("Role Not Found"));
		
		roles.add(userRole);
		user.setRoles(roles);
		
		return userService.createUser(user);
	}

}
