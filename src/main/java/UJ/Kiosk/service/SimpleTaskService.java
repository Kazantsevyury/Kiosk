package UJ.Kiosk.service;

import UJ.Kiosk.model.Task.ITask;
import UJ.Kiosk.model.Task.SimpleTask;
import UJ.Kiosk.model.TaskID.ITaskID;
import UJ.Kiosk.storage.Tasks.ITaskStorage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@Slf4j
@RequiredArgsConstructor
public class SimpleTaskService implements ITaskService {
    private final ITaskStorage taskStorage;

    public ITask create(ITask task){
        return taskStorage.createTask(task);
    }
    public List<ITask> findAll() {
        return taskStorage.retrieveAllTasks();
    }
    public void updateTask(ITask task){
        taskStorage.updateTask(task);
    }
    public void removeTaskById(ITaskID id){
        taskStorage.deleteTaskById(id);
    }

    public ITask findTaskById(ITaskID id) {
        return taskStorage.retrieveTaskById(id);
    }
}
