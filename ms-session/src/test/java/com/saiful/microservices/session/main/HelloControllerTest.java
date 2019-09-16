package com.saiful.microservices.session.main;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@RunWith(SpringRunner.class)
@WebMvcTest
public class HelloControllerTest {

	@Autowired
	MockMvc moMvc;

//	@Test
//	public void testHello() throws Exception {
//		this.moMvc.perform(get("/auth/login"))
//				.andExpect(status().isOk())
//				.andExpect(content().string("Greating from Spring Boot!"));
//	}
}
