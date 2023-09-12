package UJ.Kiosk.service;

import UJ.Kiosk.model.Task;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class TaskService {
    private final Map<Long, Task> tasks = new HashMap<>(); // Это хранение в кэше,
    // я пока не знаю, как запихать это все в БД, но через 2 недели узнаю))
    // Пока так сойдет, можно еще сделать выгрузку и загрузку этого в файл.

    public Task create(Task task){
        if(true){                                //заглушка , прописать проверку
            tasks.put(task.getId(), task);
        }
        return task;
    }
    public Collection<Task> findAll() {
        return tasks.values();
    }
    public Task updateTask(Task task, long id){
        if (tasks.containsKey(id)){
            tasks.remove(id);
            tasks.put(task.getId(), task);
            return tasks.get(task.getId());
        }
        else return null;

    }
    public void removeTaskById(long id){
        tasks.remove(id);
    }
    public void removeTask (Task task){
        tasks.remove(task.getId());
    }
    public Task findTaskById(Long id) {
        if (Objects.isNull(id)) {
            return null;
        }
        return tasks.get(id);
    }
}
