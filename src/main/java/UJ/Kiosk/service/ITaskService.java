package UJ.Kiosk.service;

import UJ.Kiosk.model.Task.ITask;
import UJ.Kiosk.model.Task.SimpleTask;
import UJ.Kiosk.model.TaskID.ITaskID;

import java.util.List;

public interface ITaskService {
    ITask create(ITask task);
    List<ITask> findAll();
    void updateTask(ITask task);
    void removeTaskById(ITaskID id);
    ITask findTaskById(ITaskID id);
}
