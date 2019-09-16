package com.saiful.microservices.session.main;

import org.springframework.security.core.GrantedAuthority;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.saiful.microservices.session.controller.ApplicationUser;

import static java.util.Collections.emptyList;

import java.util.Collection;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//		ApplicationUser applicationUser = applicationUserRepository.findByUsername(username);
	    ApplicationUser applicationUser = new ApplicationUser();
	    applicationUser.setUsername("admin");
	    applicationUser.setPassword(passwordEncoder().encode("admin"));
		
		if (applicationUser == null) {
			throw new UsernameNotFoundException(username);
		}
		return new User(applicationUser.getUsername(), applicationUser.getPassword(), (Collection<? extends GrantedAuthority>) emptyList());
	}
	
      public BCryptPasswordEncoder passwordEncoder () {
      	return new BCryptPasswordEncoder();
      } 
	
}