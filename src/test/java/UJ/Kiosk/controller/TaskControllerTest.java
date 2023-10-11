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

    @Test
    public void testGetWhenTaskExistsThenReturnTask() throws Exception {
        Mockito.when(taskService.findTaskById(validTask.getId())).thenReturn(validTask);

        mockMvc.perform(MockMvcRequestBuilders.get("/api/tasks/get/" + validTask.getId()))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json(new ObjectMapper().writeValueAsString(validTask)));

        Mockito.verify(taskService, Mockito.times(1)).findTaskById(validTask.getId());
    }

    @Test
    public void testGetWhenTaskDoesNotExistThenReturnNotFound() throws Exception {
        Mockito.when(taskService.findTaskById(validTask.getId())).thenReturn(null);

        mockMvc.perform(MockMvcRequestBuilders.get("/api/tasks/get/" + validTask.getId()))
                .andExpect(MockMvcResultMatchers.status().isNotFound());

        Mockito.verify(taskService, Mockito.times(1)).findTaskById(validTask.getId());
    }

    @Test
    public void testUpdateTaskWhenTaskExistsThenReturnUpdatedTask() throws Exception {
        Task updatedTask = new Task("Updated Task", "Updated Creator", "Updated Executor");
        Mockito.when(taskService.updateTask(updatedTask, validTask.getId())).thenReturn(updatedTask);

        mockMvc.perform(MockMvcRequestBuilders.put("/api/tasks/updatetask/" + validTask.getId())
                        .contentType("application/json")
                        .content(new ObjectMapper().writeValueAsString(updatedTask)))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json(new ObjectMapper().writeValueAsString(updatedTask)));

        Mockito.verify(taskService, Mockito.times(1)).updateTask(updatedTask, validTask.getId());
    }

    @Test
    public void testUpdateTaskWhenTaskDoesNotExistThenReturnNotFound() throws Exception {
        Task updatedTask = new Task("Updated Task", "Updated Creator", "Updated Executor");
        Mockito.when(taskService.updateTask(updatedTask, validTask.getId())).thenReturn(null);

        mockMvc.perform(MockMvcRequestBuilders.put("/api/tasks/updatetask/" + validTask.getId())
                        .contentType("application/json")
                        .content(new ObjectMapper().writeValueAsString(updatedTask)))
                .andExpect(MockMvcResultMatchers.status().isNotFound());

        Mockito.verify(taskService, Mockito.times(1)).updateTask(updatedTask, validTask.getId());
    }
}