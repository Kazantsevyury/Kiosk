package UJ.Kiosk.storage;

import UJ.Kiosk.model.Task;

import java.util.Collection;
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
    Task saveTask(Task task);

    /**
     * Retrieves a task by its unique identifier.
     *
     * @param id The unique identifier of the task.
     * @return The task with the specified identifier or null if the task is not found.
     */
    Task getTaskById(Long id);

    /**
     * Deletes a task from the storage by its unique identifier.
     *
     * @param id The unique identifier of the task to be deleted.
     * @return true if the task was successfully deleted, otherwise false.
     */
    boolean deleteTaskById(Long id);

    /**
     * Updates an existing task in the storage based on the provided task.
     * If a task with the specified identifier does not exist, the method may create a new task.
     *
     * @param task The updated task.
     */
    void updateTask(Task updatedTask);

    /**
     * Retrieves all tasks from the storage as a collection.
     *
     * @return A collection of all tasks stored in the storage.
     */
    Collection<Task> getAllTasks();
}