package UJ.Kiosk.controller;

import UJ.Kiosk.model.Task;
import UJ.Kiosk.service.TaskService;
import lombok.Value;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/api/tasks")
public class TaskController {
    private final TaskService taskService;
    @Autowired
    public TaskController (TaskService taskService){
        this.taskService = taskService;
    }
    @PostMapping("/create")
    public Task create (@RequestBody Task task){
        log.info("Invoke create method with task = {}",task);
        return taskService.create(task) ;
    }

    @GetMapping("/get/{id}")
    public Task get (@PathVariable long id){
        log.info("Invoke get method with task with id = {}",id);
        return taskService.findTaskById(id);

    }

    @PutMapping("/updatetask/{id}")
    public Task updateTask(@PathVariable long id, @RequestBody @Valid Task updatedTask) {
        log.info("Invoke updateFilm method for task with id = {}", id);
        taskService.updateTask(updatedTask,id);
        return taskService.findTaskById(id);
    }

}
