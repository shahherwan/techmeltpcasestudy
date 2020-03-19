package com.spring.springcore.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "firstname")
    @NotEmpty
    private String first_name;
    
    @Column(name = "lastname")
    @NotEmpty
    private String last_name;
    
    @Column(name = "username", unique = true)
    @NotEmpty
    private String username;
    
    @Column(name = "password")
    @NotEmpty
    private String password;

    @Transient
    private String passwordConfirm;

    @ManyToMany
    private Set<Role> roles;

	public Long getId() {
		return id;
	}

	public String getFirst_name() {
		return first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public String getPasswordConfirm() {
		return passwordConfirm;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setFirst_name(String first_name) {
		first_name = first_name.substring(0,1).toUpperCase() + first_name.substring(1).toLowerCase();
		this.first_name = first_name;
	}

	public void setLast_name(String last_name) {
		last_name = last_name.substring(0,1).toUpperCase() + last_name.substring(1).toLowerCase();
		this.last_name = last_name;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setPasswordConfirm(String passwordConfirm) {
		this.passwordConfirm = passwordConfirm;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", first_name=" + first_name + ", last_name=" + last_name + ", username=" + username
				+ ", password=" + password + ", passwordConfirm=" + passwordConfirm + ", roles=" + roles + "]";
	}

	


}
