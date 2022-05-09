package com.classwebbeta.course;

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
public class CoursesControllerTest {

    @Autowired
    private WebApplicationContext context;
	
	@Autowired
	private MockMvc mockMvc;
	
	@Autowired
	CoursesController coursesController;

	@BeforeEach
    public void setup() {
		mockMvc = MockMvcBuilders
          .webAppContextSetup(context)
          .build();
    }

    @Test
    void testCoursesControllerIsNotNull(){
        assertNotNull(coursesController);
    }

    @Test
	void testMockMvcIsNotNull() {
		assertNotNull(mockMvc);
	}

    @Test
    void testAddCourse() throws Exception {
        mockMvc.perform(get("/courses/addCourse")).
        andExpect(status().isOk()).
        andExpect(view().name("courses"));
    }

    @Test
    void testDeleteCourse() throws Exception {
        mockMvc.perform(get("/courses/deleteCourse")).
        andExpect(status().isOk()).
        andExpect(view().name("courses"));

    }

    @Test
    void testGetStudentsPage() throws Exception {
        mockMvc.perform(get("/courses/students")).
        andExpect(status().isOk()).
        andExpect(view().name("navigate_course_page"));
    }

    @Test
    void testUpdateCourse() throws Exception {
        mockMvc.perform(get("/courses/updateCourse")).
        andExpect(status().isOk()).
        andExpect(view().name("courses"));

    }
}
