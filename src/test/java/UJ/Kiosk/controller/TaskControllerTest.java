package UJ.Kiosk.controller;

import UJ.Kiosk.model.Task;
import UJ.Kiosk.service.TaskService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@WebMvcTest(TaskController.class)
public class TaskControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TaskService taskService;

    private Task validTask;
    private Task invalidTask;

    @BeforeEach
    public void setup() {
        validTask = new Task("Test Task", "Test Creator", "Test Executor");
        invalidTask = new Task("", "", "");
    }

    @Test
    public void testCreateWhenTaskIsValidThenReturnCreatedTask() throws Exception {
        Mockito.when(taskService.create(validTask)).thenReturn(validTask);

        mockMvc.perform(MockMvcRequestBuilders.post("/api/tasks/create")
                        .contentType("application/json")
                        .content(new ObjectMapper().writeValueAsString(validTask)))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json(new ObjectMapper().writeValueAsString(validTask)));

        Mockito.verify(taskService, Mockito.times(1)).create(validTask);
    }

    @Test
    public void testCreateWhenTaskIsInvalidThenReturnBadRequest() throws Exception {
        Mockito.when(taskService.create(invalidTask)).thenThrow(new IllegalArgumentException());

        mockMvc.perform(MockMvcRequestBuilders.post("/api/tasks/create")
                        .contentType("application/json")
                        .content(new ObjectMapper().writeValueAsString(invalidTask)))
                .andExpect(MockMvcResultMatchers.status().isBadRequest());

        Mockito.verify(taskService, Mockito.times(1)).create(invalidTask);
    }
}