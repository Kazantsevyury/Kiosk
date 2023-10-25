package UJ.Kiosk.storage;

import UJ.Kiosk.model.Task;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class InMemoryTaskStorage implements TaskStorage{
    private final Map<Long, Task> tasks = new HashMap<>();

    @Override
    public Task saveTask (Task task){
        tasks.put(task.getId(), task);
        return tasks.get(task);
    };

    @Override
    public Task getTaskById (Long id){
        return tasks.get(id);
    };

    @Override
    public boolean deleteTaskById(Long id){
        Task removedTask = tasks.remove(id);
        return removedTask != null;
    };

    @Override
    public void updateTask(Task updatedTask) {
        Long idToUpdate = updatedTask.getId();

        if (tasks.containsKey(idToUpdate)) {
            tasks.put(idToUpdate, updatedTask);
        } else {

        }
    };

    @Override
    public Collection<Task> getAllTasks(){
        return tasks.values();
    };

}