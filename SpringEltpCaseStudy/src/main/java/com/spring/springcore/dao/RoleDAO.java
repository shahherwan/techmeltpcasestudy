package com.spring.springcore.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.springcore.entity.Role;

public interface RoleDAO extends JpaRepository<Role, Long>{
	public Role findByRole(String role);

}
