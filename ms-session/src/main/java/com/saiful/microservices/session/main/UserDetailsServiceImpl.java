package com.saiful.microservices.session.main;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.saiful.microservices.session.controller.ApplicationUser;

import static java.util.Collections.emptyList;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//		ApplicationUser applicationUser = applicationUserRepository.findByUsername(username);
	    ApplicationUser applicationUser = new ApplicationUser();
	    applicationUser.setUsername("admin");
	    applicationUser.setPassword(passwordEncoder().encode("admin"));
	    List<GrantedAuthority> roles = new ArrayList<>();
	    roles.add(new SimpleGrantedAuthority("ADMINISTRATOR"));
		
		if (applicationUser == null) {
			throw new UsernameNotFoundException(username);
		}
//		return new User(applicationUser.getUsername(), applicationUser.getPassword(), (Collection<? extends GrantedAuthority>) emptyList());
		return new User(applicationUser.getUsername(), applicationUser.getPassword(), roles);
	}
	
      public BCryptPasswordEncoder passwordEncoder () {
      	return new BCryptPasswordEncoder();
      } 
	
}