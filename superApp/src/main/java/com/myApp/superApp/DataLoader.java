package com.myApp.superApp;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.myApp.superApp.entity.Role;
import com.myApp.superApp.entity.RoleName;
import com.myApp.superApp.repository.RoleRepository;

@Component
public class DataLoader implements CommandLineRunner{
	
	@Autowired
	RoleRepository roleRepository;

	@Override
	public void run(String... args) throws Exception {
		addRoleIfNotFound(RoleName.ROLE_ADMIN);
		addRoleIfNotFound(RoleName.ROLE_USER);
	}

	private void addRoleIfNotFound(RoleName roleName) {
		Optional<Role> roleFound = roleRepository.findByName(roleName);
		if(!roleFound.isPresent()) {
			Role role = new Role();
			role.setName(roleName);
			roleRepository.save(role);
		}
	}

}
