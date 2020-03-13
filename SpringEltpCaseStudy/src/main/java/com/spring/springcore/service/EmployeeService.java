package com.spring.springcore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.security.crypto.bcrypt.BCrypt;

import com.spring.springcore.dao.CustomerDAO;
import com.spring.springcore.entity.Employee;

@Service
public class EmployeeService{
	
	@Autowired
	private CustomerDAO customerDAO;

	
	@Transactional
	public List<Employee> getEmployees() {
		// TODO Auto-generated method stub
		return customerDAO.findAll();
	}
	
	public String hashPassword(String password){
		return BCrypt.hashpw(password, BCrypt.gensalt());
	}
	
	public boolean checkPass(String password, String hashedPassword) {
		return BCrypt.checkpw(password, hashedPassword);

	}

}
