package com.saiful.microservices.session.main;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

//@Configuration
//@Order(1)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    public void configure(HttpSecurity http) throws Exception {
	
	http.csrf().disable()
	.authorizeRequests().antMatchers(HttpMethod.POST, "/sign-up").permitAll().anyRequest().authenticated()
	.and().httpBasic();
	
//	
//	http.requestMatchers()
//		.antMatchers("/login", "/oauth/autorize")
//		.and()
//		.authorizeRequests()
//		.anyRequest().authenticated()
//		.and()
//		.formLogin().permitAll();
    }
    
    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
	auth.inMemoryAuthentication()
		.withUser("admin")
		.password(passwordEncoder().encode("admin"))
		.roles("USER");
    }
    
    @Bean
    public BCryptPasswordEncoder passwordEncoder () {
	return new BCryptPasswordEncoder();
    } 
}
