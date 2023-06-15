package com.java.userdata.Controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.java.userdata.Entity.User;
import com.java.userdata.Entity.Response;
import com.java.userdata.Service.UserService;

import lombok.RequiredArgsConstructor;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class UserController {
	
	@Autowired
	private final UserService userService;
	
	
	@PostMapping("/signup")
	public User saveUser(@RequestBody User userdata) {
		User user =  userService.saveUser(userdata);
		return user;
	}
	
	@PostMapping("/signin")
	public ResponseEntity<?> checkUser(@RequestBody User userdata) {
		User user = userService.checkuser(userdata);
		
		return ResponseEntity.ok(new Response(user.getId() , user.getEmail(), user.getUsername()));
		
	}

	@GetMapping("/user/{id}")
	public Optional<User> getUser(@PathVariable Long id) {
		Optional<User> user = userService.findById(id);
		return user;
	}
}
