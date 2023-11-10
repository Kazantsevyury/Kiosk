package UJ.Kiosk.storage.Tasks;

import UJ.Kiosk.model.Task;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
@Slf4j
@RequiredArgsConstructor
public class InMemoryTaskStorage implements TaskStorage {
    private final Map<Integer, Task> tasks = new HashMap<>();

    @Override
    public Task createTask(Task task){
        tasks.put(task.getId(), task);
        return tasks.get(task);
    };

    @Override
    public Task retrieveTaskById (Integer id){
        return tasks.get(id);
    };

    @Override
    public boolean deleteTaskById(Integer id){
        Task removedTask = tasks.remove(id);
        return removedTask != null;
    };

    @Override
    public void updateTask(Task updatedTask) {
            tasks.put(updatedTask.getId(), updatedTask);
    };

    @Override
    public List<Task> retrieveAllTasks(){
        List<Task> usersList = new ArrayList<>(tasks.values());
        return usersList;
    };

    @Override
    public Map<Integer, Task> retrieveTaskMap(){
        return tasks;
    }

}