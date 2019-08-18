package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.UserDTO;
import com.example.demo.entity.User;
import com.example.demo.exception.ObjectNotFoundException;
import com.example.demo.repository.UserRepository;

/**
 * This class represent service user.
 * @author j.a.vasconcelos
 *
 */
@Service
public class UserService {

	@Autowired
	private UserRepository repo;
	
	/**
	 * Find all users in database;
	 * @return
	 */
	public List<User> findAll(){
		return repo.findAll();
	}
	
	/**
	 * Find user for id
	 * @param id
	 * @return
	 */
	public User findById(String id) {
		Optional<User> user = repo.findById(id);
		return user.orElseThrow(() -> new ObjectNotFoundException("Object not found!"));
	}
	
	/**
	 * Create user
	 * @param user
	 * @return
	 */
	public User create(User user) {
		user.setActive(true); //active user
		return repo.save(user);
	}
	
	public User fromDTO(UserDTO userDTO) {
		return new User(userDTO);
	}
}
