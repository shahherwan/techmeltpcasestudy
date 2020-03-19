package com.spring.springcore.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 
 *  @author Nazreen Misrawi
 * 
 *  The Employee entity representing each employee
 *  in the employees table.
 *  <p>
 *  Contains the same columns as the employees table.
 *
 */

@Entity
@Table(name = "EMPLOYEES")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "first_name")
	private String first_name;

	@Column(name = "last_name")
	private String last_name;

	@Column(name = "email")
	private String email;
	
	public Employee() {
		super();
	}


	public Employee(long id, String first_name, String last_name, String email) {
		super();
		this.first_name = first_name;
		this.last_name = last_name;
		this.email = email;

	}

	public long getId() {
		return id;
	}

	public String getFirst_name() {
		return first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public String getEmail() {
		return email;
	}

	public void setId(long id) {
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

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", first_name=" + first_name + ", last_name=" + last_name + ", email=" + email
				+ "]";
	}

}
