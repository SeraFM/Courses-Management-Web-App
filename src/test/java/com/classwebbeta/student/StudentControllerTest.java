package com.classwebbeta.student;

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
public class StudentControllerTest {

    @Autowired
    private WebApplicationContext context;
	
	@Autowired
	private MockMvc mockMvc;
	
	@Autowired
	StudentController studentController;

	@BeforeEach
    public void setup() {
		mockMvc = MockMvcBuilders
          .webAppContextSetup(context)
          .build();
    }

    @Test
    void testStudentControllerIsNotNull(){
        assertNotNull(studentController);
    }

    @Test
	void testMockMvcIsNotNull() {
		assertNotNull(mockMvc);
	}


    @Test
    void testAddStudent() throws Exception {
        mockMvc.perform(get("/courses/students/addStudent")).
        andExpect(status().isOk()).
        andExpect(view().name("courses/students"));

    }

    @Test
    void testDeleteStudent() throws Exception {
        mockMvc.perform(get("/courses/students/deleteStudent")).
        andExpect(status().isOk()).
        andExpect(view().name("courses/students"));

    }

    @Test
    void testUpdateStudent() throws Exception {
        mockMvc.perform(get("/courses/students/updateStudent")).
        andExpect(status().isOk()).
        andExpect(view().name("courses/students"));

    }
}
