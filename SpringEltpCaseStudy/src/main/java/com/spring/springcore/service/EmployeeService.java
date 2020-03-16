package com.spring.springcore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
//import org.springframework.security.crypto.bcrypt.BCrypt;

import com.spring.springcore.dao.EmployeeDAO;
import com.spring.springcore.entity.Employee;

@Service
public class EmployeeService{
	
	@Autowired
	private EmployeeDAO customerDAO;

	
	@Transactional
	public List<Employee> getEmployees() {
		// TODO Auto-generated method stub
		return customerDAO.findAll();
	}

}
