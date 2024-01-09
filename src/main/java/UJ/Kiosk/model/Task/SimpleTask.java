package UJ.Kiosk.model.Task;

import UJ.Kiosk.enums.TaskEnums.TaskPriority;
import UJ.Kiosk.enums.TaskEnums.TaskStatus;
import UJ.Kiosk.enums.TaskEnums.TaskTrackingType;
import UJ.Kiosk.model.TaskID.ITaskID;
import UJ.Kiosk.model.User.IUser;
import UJ.Kiosk.model.deadline.IDeadline;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import java.time.LocalDateTime;
import java.util.ArrayList;

@Data
@Builder
@AllArgsConstructor
@NotNull
public class SimpleTask implements ITask{

    private final int id;
    @NotBlank
    private final String name;
    @NotBlank
    private final String creator;
    @NotBlank
    private final String executor;
    private final String description;
    private final LocalDateTime creationDateTime;
    private final Integer dueDateTime;
    private final LocalDateTime deadlineDateTime;
    private final TaskTrackingType trackingType;
    private TaskStatus status;
    private final String responsibleEmployee;
    private final String completedByEmployee;
    private TaskPriority priority;

    @Override
    public ITaskID getTaskID() {
        return null;
    }

    @Override
    public void setTaskName(String name) {

    }

    @Override
    public String getTaskName() {
        return null;
    }

    @Override
    public void setTaskDescription(String desc) {

    }

    @Override
    public String getTaskDescription() {
        return null;
    }

    @Override
    public LocalDateTime getCreationTime() {
        return null;
    }

    @Override
    public void setDeadline(IDeadline dl) {

    }

    @Override
    public IDeadline getDeadline() {
        return null;
    }

    @Override
    public void setTaskTrackingType(TaskTrackingType trackingType) {

    }

    @Override
    public void setTaskStatus(TaskStatus ts) {

    }

    @Override
    public TaskStatus getTaskStatus() {
        return null;
    }

    @Override
    public void setTaskPriority(TaskPriority tp) {

    }

    @Override
    public TaskPriority getTaskPriority() {
        return null;
    }

    @Override
    public void setTaskType(String taskType) {

    }

    @Override
    public String getTaskType() {
        return null;
    }

    @Override
    public void setTaskOwner(IUser taskOwner) {

    }

    @Override
    public IUser getTaskOwner() {
        return null;
    }

    @Override
    public void assignTo(ArrayList<IUser> executors) {

    }

    @Override
    public ArrayList<IUser> getExecutors() {
        return null;
    }

    @Override
    public void updateExecutorsReport(String comment) {

    }

    @Override
    public String getExecutorsReport() {
        return null;
    }

    @Override
    public void updateOwnersReview(String comment) {

    }

    @Override
    public String getOwnersReview() {
        return null;
    }
}
