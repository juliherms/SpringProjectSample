package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Profile;
/**
 * This class repsonsible to access mongo database
 * @author j.a.vasconcelos
 *
 */
@Repository
public interface ProfileRepository extends MongoRepository<Profile, String> {

	/**
	 * Find profile by name.
	 * @param name
	 * @return
	 */
	Optional<Profile> findByName(String name);
}
