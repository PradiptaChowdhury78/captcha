package com.ibm.demo.spring.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ibm.demo.entity.UserLogin;


@Repository
public interface UserDAO extends CrudRepository<UserLogin, String> {
	
	
	/*
	 * public List<Employee> getAllEmployees();
	 * 
	 * public Employee updateEmployee(Employee emp);
	 * 
	 * public Employee addEmployee(Employee emp);
	 * 
	 * public Employee getEmployee(String empNo);
	 * 
	 * public void deleteEmployee(String empNo);
	 */
	

}
