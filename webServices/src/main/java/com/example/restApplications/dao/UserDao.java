package com.example.restApplications.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.restApplications.entity.User;


@Repository
public interface UserDao extends JpaRepository<User, Integer>{
	
}
