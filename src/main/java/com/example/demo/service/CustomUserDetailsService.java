package com.example.demo.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Profile;
import com.example.demo.entity.User;
import com.example.demo.exception.ObjectNotFoundException;
import com.example.demo.repository.UserRepository;

/**
 * This class responsible to integration spring security
 * 
 * @author j.a.vasconcelos
 *
 */
@Service
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private UserRepository repo;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

		Optional<User> user = repo.findByEmail(email);
		if (!user.isPresent()) {
			throw new UsernameNotFoundException(String.format("UserNotExist"));
		} else if (!user.get().isActive()) {
			throw new ObjectNotFoundException(String.format("UserNotActive"));
		}

		return new UserRepositoryUserDetails(user.get());
	}
	
	private final List<GrantedAuthority> getGrantedAuthorities(final Collection<Profile> profiles){
		final List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		for(Profile profile : profiles) {
			authorities.add(new SimpleGrantedAuthority(profile.getName()));
		}
		return authorities;
	}
	
	public final Collection<? extends GrantedAuthority> getAuthorities(final Collection<Profile> profiles){
		return getGrantedAuthorities(profiles);
	}

	private final static class UserRepositoryUserDetails extends User implements UserDetails {

		private static final long serialVersionUID = 1L;

		public UserRepositoryUserDetails(User user) {
			super(user);
		}

		@Override
		public Collection<? extends GrantedAuthority> getAuthorities() {
			return getProfiles();
		}

		@Override
		public String getUsername() {
			return getEmail();
		}

		@Override
		public boolean isAccountNonExpired() {
			return true;
		}

		@Override
		public boolean isAccountNonLocked() {
			return true;
		}

		@Override
		public boolean isCredentialsNonExpired() {
			return true;
		}

		@Override
		public boolean isEnabled() {
			return true;
		}
	}
}
