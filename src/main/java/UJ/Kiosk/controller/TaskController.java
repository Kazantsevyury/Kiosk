package UJ.Kiosk.controller;

import UJ.Kiosk.model.Task;
import lombok.Value;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/api/tasks")
public class TaskController {
    private final Map<Long, Task> tasks = new HashMap<>(); // Это хранение в кэше,
    // я пока не знаю, как запихать это все в БД, но через 2 недели узнаю))
    // Пока так сойдет, можно еще сделать выгрузку и загрузку этого в файл.

    @PostMapping("/save")
    public Task save (@RequestBody Task task){
        log.info("Invoke save method with task = {}",task);
        tasks.put(task.getId(),task);
        return task;
    }

    @GetMapping("/get/{id}")
    public Task get (@PathVariable long id){
        log.info("Invoke get method with task = {}",tasks.get(id));
        return tasks.get(id);
    }

    @PutMapping("/updatetask/{id}")
    public Task updateTask(@PathVariable long id, @RequestBody @Valid Task updatedTask) {
        if (tasks.containsKey(id)) {
            log.info("Invoke updateFilm method for task with id = {}", id);
            tasks.remove(id);
            tasks.put(updatedTask.getId(), updatedTask);
            return updatedTask;
        } else {
            return null;
        }
    }

}
