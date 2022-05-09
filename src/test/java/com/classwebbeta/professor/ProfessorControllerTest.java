package com.classwebbeta.professor;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class ProfessorControllerTest {

    @Autowired
    private WebApplicationContext context;
	
	@Autowired
	private MockMvc mockMvc;
	
	@Autowired
	ProfessorController professorController;

	@BeforeEach
    public void setup() {
		mockMvc = MockMvcBuilders
          .webAppContextSetup(context)
          .build();
    }

    @Test
    void testProfessorControllerIsNotNull(){
        assertNotNull(professorController);
    }

    @Test
	void testMockMvcIsNotNull() {
		assertNotNull(mockMvc);
	}

    @Test
    void testGetAboutPage() throws Exception {
        mockMvc.perform(get("/about")).
        andExpect(status().isOk()).
        andExpect(view().name("about_page"));

    }

    @Test
    void testGetCoursesPage() throws Exception {
        mockMvc.perform(get("/courses")).
        andExpect(status().isOk()).
        andExpect(model().attributeExists("courses")).
        andExpect(view().name("courses_page"));
    }

    @Test
    void testGetHomePage() throws Exception {
        mockMvc.perform(get("/home")).
        andExpect(status().isOk()).
        andExpect(view().name("home_page"));

    }

    @Test
    void testGetLoginPage() throws Exception {
        mockMvc.perform(get("/login")).
        andExpect(status().isOk()).
        andExpect(model().attributeExists("loginRequest")).
        andExpect(view().name("login"));
    }

    @Test
    void testLogin() throws Exception {
        mockMvc.perform(get("/login")).
        andExpect(status().isOk()).
        andExpect(model().attributeExists("userLogin")).
        andExpect(view().name("home_page"));
    }
}
