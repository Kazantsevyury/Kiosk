package UJ.Kiosk.model.Task;

import UJ.Kiosk.enums.TaskEnums.TaskPriority;
import UJ.Kiosk.enums.TaskEnums.TaskStatus;
import UJ.Kiosk.enums.TaskEnums.TaskTrackingType;
import UJ.Kiosk.model.TaskID.ITaskID;
import UJ.Kiosk.model.User.IUser;
import UJ.Kiosk.model.deadline.IDeadline;

import java.time.LocalDateTime;
import java.util.ArrayList;

public interface ITask {
    ITaskID getTaskID();
    void setTaskName(String name);
    String getTaskName();
    void setTaskDescription(String desc);
    String getTaskDescription();
    LocalDateTime getCreationTime();
    void setDeadline(IDeadline dl);
    IDeadline getDeadline();
    void setTaskTrackingType(TaskTrackingType trackingType);
    void setTaskStatus(TaskStatus ts);
    TaskStatus getTaskStatus();
    void setTaskPriority(TaskPriority tp);
    TaskPriority getTaskPriority();
    void setTaskType(String taskType);
    String getTaskType();
    void setTaskOwner(IUser taskOwner);
    IUser getTaskOwner();
    void assignTo(ArrayList<IUser> executors);
    ArrayList<IUser> getExecutors();
    void updateExecutorsReport(String comment);
    String getExecutorsReport();
    void updateOwnersReview(String comment);
    String getOwnersReview();
}
