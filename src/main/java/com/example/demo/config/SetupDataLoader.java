package com.example.demo.config;

import java.util.Arrays;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ContextRefreshedEvent;

import com.example.demo.entity.Profile;
import com.example.demo.entity.User;
import com.example.demo.repository.ProfileRepository;
import com.example.demo.repository.UserRepository;

@Configuration
public class SetupDataLoader implements ApplicationListener<ContextRefreshedEvent> {

	@Autowired
	private UserRepository repo;
	
	@Autowired
	private ProfileRepository repoProfile;
	
	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		
		repo.deleteAll();
		repoProfile.deleteAll();
		
		Profile profileAdmin = createProfileIfNotFound("ROLE_ADMIN");
		Profile profileUser = createProfileIfNotFound("ROLE_USER");
		
		
		User jose = new User("José","Carvalho","jose@gmail.com",true);
		User fred = new User("Fred","Vasconcelos","fredvasco@gmail.com",true);
		
		jose.setProfiles(Arrays.asList(profileUser));
		fred.setProfiles(Arrays.asList(profileAdmin));
		
		createUserINotFound(jose);
		createUserINotFound(fred);
	}
	
	
	
	private User createUserINotFound(User user) {
		Optional<User> obj = repo.findByEmail(user.getEmail());
		if(obj.isPresent()) {
			return obj.get();
		}
		return repo.save(user);
	}
	
	private Profile createProfileIfNotFound(String name) {
		Optional<Profile> profile = repoProfile.findByName(name);
		if(profile.isPresent()) {
			return profile.get();
		}
		return repoProfile.save(new Profile(name));
	}

}
