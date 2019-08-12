package com.example.demo.resource;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.User;

@RestController
@RequestMapping("/api")
public class UserResource {
	
	/**
	 * Return all users from system
	 * @return
	 */
	@GetMapping("/users")
	public ResponseEntity<List<User>> findAll(){
		
		List<User> users = new ArrayList<User>();
		users.add(new User("João","Pedro","joaopedro@gmail.com"));
		users.add(new User("Carla","Maria","carla@gmail.com"));
		
		return ResponseEntity.ok().body(users);
		
	}
}
