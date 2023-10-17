package UJ.Kiosk.model;

import UJ.Kiosk.enums.TaskPriority;
import UJ.Kiosk.enums.TaskStatus;
import UJ.Kiosk.enums.TrackingType;
import UJ.Kiosk.idGenerator.IdGenerator;
import lombok.Data;

import javax.validation.constraints.NotBlank;

import java.time.LocalDateTime;

@Data
public class Task {

    private final Long id;
    @NotBlank
    private final String name;
    @NotBlank
    private final String creator; // должно быть типом User.
    @NotBlank
    private final String executor;  // должно быть типом User.
    private final String description;
    private final LocalDateTime creationDateTime;
    private final Integer dueDateTime;
    private final LocalDateTime deadlineDateTime;
    private final TrackingType trackingType;
    private TaskStatus status;
    private final String responsibleEmployee;  // должно быть типом User.
    private final String completedByEmployee;  // должно быть типом User.
    private TaskPriority priority;

    public Task(Long id,String name, String creator, String executor) {
        this.id = id ;
        this.name = name;
        this.description = null;
        this.creator = creator;
        this.executor = executor;
        this.creationDateTime = LocalDateTime.now();
        this.dueDateTime = 24;
        this.status = TaskStatus.NEW;
        this.deadlineDateTime = LocalDateTime.now().plusHours(dueDateTime); // По умолчанию , 24 часа с момента создания
        this.responsibleEmployee = executor; // По умолчанию ответственный - исполнитель
        this.completedByEmployee = null; // По умолчанию - задача не выполнена
        this.priority = TaskPriority.NORMAL; // По умолчанию  стандартный приоритет
        this.trackingType = TrackingType.ALL; // По умолчанию отслеживать все
    }

}
