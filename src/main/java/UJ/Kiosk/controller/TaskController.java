package UJ.Kiosk.controller;

import UJ.Kiosk.model.Task.ITask;
import UJ.Kiosk.model.TaskID.ITaskID;
import UJ.Kiosk.service.ITaskService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Slf4j
@RestController
@RequestMapping("/api/tasks")
public class TaskController {
    private final ITaskService taskService;
    @Autowired
    public TaskController (ITaskService taskService){
        this.taskService = taskService;
    }
    @PostMapping("/create")
    public ITask create (@RequestBody ITask task){
        log.info("Invoke create method with task = {}",task);
        return taskService.create(task) ;
    }

    @GetMapping("/get/{id}")
    public ITask get (@PathVariable ITaskID id){
        log.info("Invoke get method with task with id = {}",id);
        return taskService.findTaskById(id);

    }

    @PutMapping("/updatetask/{id}")
    public void updateTask(@PathVariable ITaskID id, @RequestBody @Valid ITask updatedTask) {
        log.info("Invoke updateFilm method for task with id = {}", id);
        taskService.updateTask(updatedTask);
    }

}
