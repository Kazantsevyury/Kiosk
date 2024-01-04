package UJ.Kiosk.service;

import UJ.Kiosk.model.Task;
import UJ.Kiosk.storage.Tasks.TaskStorage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@Slf4j
@RequiredArgsConstructor
public class TaskService {
    private final TaskStorage taskStorage;

    public Task create(Task task){
        return taskStorage.createTask(task);
    }
    public List<Task> findAll() {
        return taskStorage.retrieveAllTasks();
    }
    public void updateTask(Task task){
        taskStorage.updateTask(task);
    }
    public void removeTaskById(Integer id){
        taskStorage.deleteTaskById(id);
    }

    public Task findTaskById(Integer id) {
        return taskStorage.retrieveTaskById(id);
    }
}
