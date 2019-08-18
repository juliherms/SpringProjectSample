package com.example.demo.resource;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.UserDTO;
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
	private UserService service;
	
	/**
	 * Return all users from system
	 * @return
	 */
	@GetMapping("/users")
	public ResponseEntity<List<UserDTO>> findAll(){
		List<User> users = service.findAll();
		List<UserDTO> listDTO = users.stream().map(x -> new UserDTO(x)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
	}

	/**
	 * Return user for param id.
	 * @param id
	 * @return
	 */
	@GetMapping("/users/{id}")
	public ResponseEntity<UserDTO> findById(@PathVariable String id){
		User user = service.findById(id);
		return ResponseEntity.ok().body(new UserDTO(user));
	}

	/**
	 * Create user 
	 * @param userDTO
	 * @return
	 */
	@PostMapping("/users")
	public ResponseEntity<UserDTO> create(@RequestBody UserDTO userDTO){
		User user = service.fromDTO(userDTO);
		return ResponseEntity.ok().body(new UserDTO(service.create(user)));
	}
	
	/**
	 * Update user
	 * @param id
	 * @param userDTO
	 * @return
	 */
	@PutMapping("/users/{id}")
	public ResponseEntity<UserDTO> update(@PathVariable String id, @RequestBody UserDTO userDTO){
		
		User user = service.fromDTO(userDTO);
		user.setId(id);
		return ResponseEntity.ok().body(new UserDTO(service.update(user)));
	}
	
	/**
	 * Delete user 
	 * @param id
	 * @return
	 */
	@DeleteMapping("/users/{id}")
	public ResponseEntity<Void> delete(@PathVariable String id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
}
