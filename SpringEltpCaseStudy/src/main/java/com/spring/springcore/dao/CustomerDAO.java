package com.spring.springcore.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.springcore.entity.Employee;

public interface CustomerDAO extends JpaRepository<Employee, Integer>{

}
