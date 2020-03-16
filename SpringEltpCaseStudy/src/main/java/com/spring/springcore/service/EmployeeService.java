package com.spring.springcore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
//import org.springframework.security.crypto.bcrypt.BCrypt;

import com.spring.springcore.dao.EmployeeDAO;
import com.spring.springcore.entity.Employee;

/**
 * 
 * Service class for Employee.
 * <p>
 * This class accesses the employee DAO for CRUD operations.
 * 
 * @author 
 * 		Nazreen Misrawi
 *
 */
@Service
public class EmployeeService{
	
	/**
	 * 
	 * Autowire the  employee DAO.
	 * This allows the service class to 
	 * access the employee DAO's properties
	 * and methods.
	 * 
	 * @author 
	 * 		Nazreen Misrawi
	 */
	@Autowired
	private EmployeeDAO employeeDAO;

	/**
	 * 
	 * This method lists all the records in the
	 * employee table.
	 * 
	 * @return
	 * 		List of employee entities
	 * 
	 * @author
	 * 		Nazreen Misrawi
	 */
	@Transactional
	public List<Employee> getEmployees() {
		return employeeDAO.findAll();
	}

}
