package kz.bitlab.bigprojecttrello.mapper;

import kz.bitlab.bigprojecttrello.dto.TaskCategoryDto;
import kz.bitlab.bigprojecttrello.model.TaskCategory;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TaskCategoryMapper {

    TaskCategoryDto toDto(TaskCategory taskCategory);

    List<TaskCategoryDto> toDtos(List<TaskCategory> taskCategories);

}
