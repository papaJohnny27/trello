package kz.bitlab.bigprojecttrello.mapper;

import kz.bitlab.bigprojecttrello.dto.TaskDto;
import kz.bitlab.bigprojecttrello.model.Task;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TaskMapper {

    TaskDto toDto(Task task);

    List<TaskDto> toDtos(List<Task> tasks);
}
