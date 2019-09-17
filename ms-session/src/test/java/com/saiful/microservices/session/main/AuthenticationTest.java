package com.saiful.microservices.session.main;

import static com.saiful.microservices.session.main.SecurityConstants.EXPIRATION_TIME;
import static com.saiful.microservices.session.main.SecurityConstants.SECRET;
import static com.saiful.microservices.session.main.SecurityConstants.TOKEN_PREFIX;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class AuthenticationTest {

    public static String authentication() {
	String token = null;
	UsernamePasswordAuthenticationToken auth = tokenValidate(token);

	if (!auth.isAuthenticated()) {
	    token = TOKEN_PREFIX + Jwts.builder().setSubject("admin")
		    .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
		    .signWith(SignatureAlgorithm.HS512, SECRET).compact();
	}
	
	return token;
    }

    public static UsernamePasswordAuthenticationToken tokenValidate(String token) {
	if (token != null) {
	    // parse the token.
	    String user = Jwts.parser().setSigningKey(SECRET).parseClaimsJws(token.replace(TOKEN_PREFIX, "")).getBody()
		    .getSubject();
	    if (user != null) {
		List<GrantedAuthority> roles = new ArrayList<>();
		return new UsernamePasswordAuthenticationToken(user, null, roles);
	    }
	}
	return new UsernamePasswordAuthenticationToken(null, null);
    }
    
}
