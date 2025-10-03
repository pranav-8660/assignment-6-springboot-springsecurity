package com.pranavv51.assignment_2_developer_task_tracker;


import com.pranavv51.assignment_2_developer_task_tracker.entity.Developer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import tools.jackson.databind.ObjectMapper;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class DeveloperControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void testCreateDeveloper() throws Exception {
        Developer developer = new Developer();
        developer.setName("Alice Johnson");
        developer.setEmail("alice@example.com");

        // Assuming project with id=1 exists
        mockMvc.perform(post("/api/developers/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(developer)))
                .andExpect(status().isOk());
    }

    @Test
    public void testGetDevelopersByProject() throws Exception {
        mockMvc.perform(get("/api/developers/project/1"))
                .andExpect(status().isOk());
    }
}
