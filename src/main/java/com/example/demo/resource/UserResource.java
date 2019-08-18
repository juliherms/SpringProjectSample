package com.example.demo.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;

/**
 * This class responsible to access collections users.
 * @author j.a.vasconcelos
 *
 */
@RestController
@RequestMapping("/api")
public class UserResource {
	
	@Autowired
	private UserService userService;
	
	/**
	 * Return all users from system
	 * @return
	 */
	@GetMapping("/users")
	public ResponseEntity<List<User>> findAll(){
		
		List<User> users = userService.findAll();
		return ResponseEntity.ok().body(users);
	}
}
