package com.gospeller.rest.service;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.gospeller.rest.models.AppUser;
import com.gospeller.rest.models.UserDTO;
import com.gospeller.rest.repository.AppUserRepository;

@Service
public class JwtUserDetailsService implements UserDetailsService{
	
	@Autowired
	private AppUserRepository appUserRepository;
	
	@Autowired
	private PasswordEncoder bcryptEncoder;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// search in DB
		Optional<AppUser> user = appUserRepository.findById(username);
		
		if (user.get() != null) {
			return new User(user.get().getUsername(), user.get().getPassword() ,
					new ArrayList<>());
		} else {
			throw new UsernameNotFoundException("User not found with username: " + username);
		}
	}
	
	public AppUser save(UserDTO user) {
		AppUser newUser = new AppUser();
		newUser.setUsername(user.getUsername());
		newUser.setPassword(bcryptEncoder.encode(user.getPassword()));
		return appUserRepository.save(newUser);
	}
	

}
