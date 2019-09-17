package com.saiful.microservices.session.main;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import static com.saiful.microservices.session.main.SecurityConstants.EXPIRATION_TIME;
import static com.saiful.microservices.session.main.SecurityConstants.HEADER_STRING;
import static com.saiful.microservices.session.main.SecurityConstants.SECRET;
import static com.saiful.microservices.session.main.SecurityConstants.TOKEN_PREFIX;
import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@RunWith(SpringRunner.class)
@WebMvcTest
public class HelloControllerTest {

    @Autowired
    MockMvc moMvc;

    @LocalServerPort
    private String port;

    public static String token;

    @BeforeClass
    public static void authentication() {
	token = AuthenticationTest.authentication();
    }  

//    @BeforeClass
//    public void login() throws Exception {
//	MvcResult mvcResult = this.moMvc
//		.perform(post("/login").contentType(MediaType.APPLICATION_JSON)
//			.content("{" + "    \"username\": \"admin\"," + "    \"password\": \"admin\"" + "}"))
//		.andExpect(status().isOk()).andExpect(header().exists("Authorization"))
//		.andDo(MockMvcResultHandlers.print()).andReturn();
//
//	this.token = mvcResult.getResponse().getHeader("Authorization");
//    }

    @Before
    public void tokenValidation() throws Exception {
	if (token == null) { 
	    authentication();
	    
	    // Auth by path (URL)
	    // login();
	}

    }

    @Test
    public void testHello() throws Exception {
	this.moMvc.perform(get("/hello").header("Authorization", token)).andExpect(status().isOk())
		.andExpect(content().string("Greating from Spring Boot!"));
    }

    @Test
    public void testPort() {
	assertEquals("8081", port);
    }
}
