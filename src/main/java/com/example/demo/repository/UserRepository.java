package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.User;

/**
 * this respository responsible to access document user.
 * @author j.a.vasconcelos
 *
 */
@Repository
public interface UserRepository extends MongoRepository<User, String> {

	Optional<User> findByEmail(String email);
}
