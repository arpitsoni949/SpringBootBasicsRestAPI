package com.example.user;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class UserDaoService {
	private static List<User> list=new ArrayList<User>();
	private static Integer userCount=3;
	static {
		list.add(new User(1, "arpit", new Date()));
		list.add(new User(2, "ankit", new Date()));
		list.add(new User(3, "rahul", new Date()));
	}
	
	public List<User> findAll() {
		return list;
	}
	
	public User save(User user) {
		if(user.getId()==null) {
			userCount++;
		}
		user.setId(userCount);
		list.add(user);
		return user;
	}
	public User findOne(Integer id) {
		for(User user:list) {
			if(user.getId().equals(id)) {
				return user;
			}
		}
		return null;
	}
	
	public User delete(Integer id) {
		Iterator<User> itr=list.iterator();
		while(itr.hasNext()) {
			User user=itr.next();
			if(user.getId()==id) {
				list.remove(user);
				return user;
			}
		}
		return null;
	}
}
