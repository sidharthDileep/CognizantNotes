package com.myApp.superApp.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.myApp.superApp.entity.Role;
import com.myApp.superApp.entity.RoleName;

public interface RoleRepository extends JpaRepository<Role, Long>{

	Optional<Role> findByName(RoleName roleName);
	
}
