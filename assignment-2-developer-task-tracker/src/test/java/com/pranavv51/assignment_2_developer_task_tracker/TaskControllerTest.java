package com.pranavv51.assignment_2_developer_task_tracker;

import com.pranavv51.assignment_2_developer_task_tracker.entity.Task;
import com.pranavv51.assignment_2_developer_task_tracker.enums.Priority;
import com.pranavv51.assignment_2_developer_task_tracker.enums.Status;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import tools.jackson.databind.ObjectMapper;

import java.time.LocalDate;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class TaskControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void testAssignTaskToDeveloper() throws Exception {
        Task task = new Task();
        task.setTitle("Setup Spring Security");
        task.setDescription("Implement login/logout");
        task.setPriority(Priority.HIGH);
        task.setStatus(Status.TODO);
        task.setDueDate(LocalDate.now().plusDays(3));

        // Assuming developer with id=1 exists
        mockMvc.perform(post("/api/tasks/developer/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(task)))
                .andExpect(status().isOk());
    }

    @Test
    public void testGetTasksForDeveloper() throws Exception {
        mockMvc.perform(get("/api/tasks/developer/1"))
                .andExpect(status().isOk());
    }

    @Test
    public void testGetOverdueTasks() throws Exception {
        mockMvc.perform(get("/api/tasks/overdue"))
                .andExpect(status().isOk());
    }
}