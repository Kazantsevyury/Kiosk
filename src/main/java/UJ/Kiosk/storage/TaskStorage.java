package UJ.Kiosk.storage;

import UJ.Kiosk.model.Task;

public interface TaskStorage {
    Task save (Task task);
    Task getById (long id);

}
