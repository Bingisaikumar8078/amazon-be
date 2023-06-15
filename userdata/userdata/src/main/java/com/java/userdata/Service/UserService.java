package com.java.userdata.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.userdata.Entity.User;
import com.java.userdata.Repository.UserRepository;


@Service
public class UserService {
	
	@Autowired
	 UserRepository  userRepository;

	
	public User saveUser(User user) {
		return userRepository.save(user);
	}
	


	public Optional<User> findById(Long id) {
		// TODO Auto-generated method stub
		return userRepository.findById(id);
	}



	public User checkuser(User userdata) {
		// TODO Auto-generated method stub
		User user = userRepository.getUserByUsername(userdata.getUsername());
		
		if(user.getPassword().equals(user.getPassword())) {
			return user;
		}
		else {
			return null;
		}
	}
}
