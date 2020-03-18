package com.spring.springcore.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
//import org.springframework.security.crypto.bcrypt.BCrypt;
import com.spring.springcore.dao.EmployeeDAO;
import com.spring.springcore.entity.Employee;
import com.spring.springcore.exception.EmployeeNotFoundException;

/**
 * 
 * Service class for Employee.
 * <p>
 * This class accesses the employee DAO for CRUD operations.
 * 
 * @author Nazreen Misrawi
 *
 */
@Service
public class EmployeeService {

	/**
	 * 
	 * Autowire the employee DAO. This allows the service class to access the
	 * employee DAO's properties and methods.
	 * 
	 * @author Nazreen Misrawi
	 */
	@Autowired
	private EmployeeDAO employeeDAO;

	/**
	 * 
	 * This method lists all the records in the employee table.
	 * 
	 * @return List of employee entities
	 * 
	 * @author Nazreen Misrawi
	 */
	@Transactional
	public List<Employee> getEmployees() {
		return employeeDAO.findAll();
	}

	// Update on employee
	@Transactional
	public Employee updateEmployee(long id, Employee entity) {
		Optional<Employee> employee = employeeDAO.findById(id);
		if (entity.getId() == 0) {
			entity = employeeDAO.save(entity);

			return entity;
		} else {
			if (employee.isPresent()) {
				Employee newEmp = employee.get();
				newEmp.setEmail(entity.getEmail());
				newEmp.setFirst_name(entity.getFirst_name());
				newEmp.setLast_name(entity.getLast_name());
				newEmp = employeeDAO.save(newEmp);
				return newEmp;
			}
			else {
				entity = employeeDAO.save(entity);

				return entity;
			}
		}
	}

	// return employee list
	public Employee getEmployeeById(Long id) throws EmployeeNotFoundException {
		Optional<Employee> employee = employeeDAO.findById(id);

		if (employee.isPresent()) {
			return employee.get();
		} else {
			throw new EmployeeNotFoundException("No employee record exist for given id");
		}
	}
	// Delete Employee by id
		public void deleteEmployeeById(Long id) throws EmployeeNotFoundException {
			Optional<Employee> employee = employeeDAO.findById(id);

			if (employee.isPresent()) {
				employeeDAO.deleteById(id);
			} else {
				throw new EmployeeNotFoundException("No employee record exist for given id");
			}
		}
		//add Employee
		public Employee addEmployee(Employee entity) {
			Employee employee = new Employee();
			employee = employeeDAO.save(entity);
			
			return entity;
		}

}
