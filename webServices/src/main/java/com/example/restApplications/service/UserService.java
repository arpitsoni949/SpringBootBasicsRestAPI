package com.example.restApplications.service;

import java.util.List;

import com.example.restApplications.entity.User;

public interface UserService {
	List<User> findAll();
	User saveOrUpdate(User user);
	void deleteUser(Integer id);
	User getUserById(Integer id);
}
