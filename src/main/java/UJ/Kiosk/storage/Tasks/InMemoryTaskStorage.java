package UJ.Kiosk.storage.Tasks;

import UJ.Kiosk.model.Task.ITask;
import UJ.Kiosk.model.TaskID.ITaskID;
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
public class InMemoryTaskStorage implements ITaskStorage {
    private final Map<ITaskID, ITask> tasks = new HashMap<>();

    @Override
    public ITask createTask(ITask task){
        tasks.put(task.getTaskID(), task);
        return tasks.get(task);
    };

    @Override
    public ITask retrieveTaskById (ITaskID id){
        return tasks.get(id);
    };

    @Override
    public boolean deleteTaskById(ITaskID id){
        ITask removedTask = tasks.remove(id);
        return removedTask != null;
    };

    @Override
    public void updateTask(ITask updatedTask) {
            tasks.put(updatedTask.getTaskID(), updatedTask);
    };

    @Override
    public List<ITask> retrieveAllTasks(){
        List<ITask> usersList = new ArrayList<>(tasks.values());
        return usersList;
    };

    @Override
    public Map<ITaskID, ITask> retrieveTaskMap(){
        return tasks;
    }

}