package kz.bitlab.bigprojecttrello.dto;

import kz.bitlab.bigprojecttrello.model.TaskStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TasksDto {
    private Long id;
    private String title;
    private String description;
    private TaskStatus status;

}
