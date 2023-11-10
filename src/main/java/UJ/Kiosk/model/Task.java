package UJ.Kiosk.model;

import UJ.Kiosk.enums.TaskPriority;
import UJ.Kiosk.enums.TaskStatus;
import UJ.Kiosk.enums.TrackingType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NotNull
public class Task {

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
    private final TrackingType trackingType;
    private TaskStatus status;
    private final String responsibleEmployee;
    private final String completedByEmployee;
    private TaskPriority priority;

}
