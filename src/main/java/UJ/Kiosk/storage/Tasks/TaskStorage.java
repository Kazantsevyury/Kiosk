package UJ.Kiosk.storage.Tasks;

import UJ.Kiosk.model.Task;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

/**
 * The TaskStorage interface represents a contract for classes
 * that manage a storage of tasks.
 */
public interface TaskStorage {
    /**
     * Saves a task in the storage.
     *
     * @param task The task to be saved.
     * @return The saved task.
     */
    Task createTask(@Valid @RequestBody Task task);

    /**
     * Retrieves a task by its unique identifier.
     *
     * @param id The unique identifier of the task.
     * @return The task with the specified identifier or null if the task is not found.
     */
    Task retrieveTaskById(Integer id);

    /**
     * Deletes a task from the storage by its unique identifier.
     *
     * @param id The unique identifier of the task to be deleted.
     * @return true if the task was successfully deleted, otherwise false.
     */
    boolean deleteTaskById(Integer id);

    /**
     * Updates an existing task in the storage based on the provided task.
     * If a task with the specified identifier does not exist, the method may create a new task.
     *
     * @param updatedTask The updated task.
     */
    void updateTask(@Valid @RequestBody Task updatedTask);

    /**
     * Retrieves all tasks from the storage as a List.
     *
     * @return A collection of all tasks stored in the storage.
     */
    List<Task> retrieveAllTasks();
    /**
     * Retrieves all tasks from the storage as a Map.
     *
     * @return A Map <Integer, Task>  of all tasks stored in the storage.
     */
    Map<Integer, Task> retrieveTaskMap();

}