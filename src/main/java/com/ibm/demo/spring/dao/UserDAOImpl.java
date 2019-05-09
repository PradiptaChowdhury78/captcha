package com.ibm.demo.spring.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.ibm.demo.entity.UserLogin;


@Service
public class UserDAOImpl {

	@Autowired
	private UserDAO userDao;

	public ArrayList<UserLogin> getUser(String username) {
		ArrayList<UserLogin> usrList = new ArrayList();
		userDao.findAll().forEach(usrList::add);
		return usrList;
	}

	public void addUser(UserLogin usr) {
		userDao.save(usr);
	}

	public void updateEmployee(String username, UserLogin usr) {

		userDao.save(usr);

	}

	public void deleteEmployee(String username) {

		userDao.delete(username);
	}

	

	
}
