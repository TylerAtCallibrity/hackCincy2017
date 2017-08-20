package com.callibrity.muffaletta.hello;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.hamcrest.core.Is;
import org.hamcrest.core.IsCollectionContaining;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

/**
 * Created by MMiller on 19/8/2017 (Sat) at 12:57.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class HelloWorldControllerTest {
	@Autowired
	private WebApplicationContext webApplicationContext;

	private MockMvc mockMvc;

	@Before
	public void setup() {
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}

	@Test
	public void apiHello_returnsIngredientsList() throws Exception {
		final String ingre1 = "ingre1";
		final String ingre2 = "ingre2";
		mockMvc.perform(post("/api/hello")
				.param("ingredients", ingre1)
				.param("ingredients", ingre2)
		)
				.andExpect(status().isOk())
				.andExpect(jsonPath("data").value(IsCollectionContaining.hasItems(ingre1, ingre2)))
		;
	}

	@Test
	public void apiHelloBadRequest_returnsError() throws Exception {
		mockMvc.perform(post("/api/hello"))

				.andExpect(status().isOk())
				.andExpect(jsonPath("error").value(Is.is("Please provide ingredients")))
		;
	}
}