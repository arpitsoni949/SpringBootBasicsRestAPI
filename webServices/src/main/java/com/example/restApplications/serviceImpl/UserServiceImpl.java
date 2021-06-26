package com.example.restApplications.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.restApplications.dao.UserDao;
import com.example.restApplications.entity.User;
import com.example.restApplications.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserDao userDao;
	
	public List<User> findAll() {
		List<User> userList=userDao.findAll();
		System.out.println("userList: "+userList);
		return userList;
	}
	
	public User saveOrUpdate(User user) {
		return userDao.save(user);
	}

	public void deleteUser(Integer id) {
		User user=userDao.getOne(id);
		userDao.delete(user);
	}

	public User getUserById(Integer id) {
		return userDao.getById(id);
	}
}
