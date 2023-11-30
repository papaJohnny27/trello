package kz.bitlab.bigprojecttrello.mapper;

import kz.bitlab.bigprojecttrello.dto.CommentDto;
import kz.bitlab.bigprojecttrello.model.Comment;
import kz.bitlab.bigprojecttrello.model.Task;
import org.mapstruct.AfterMapping;
import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Mappings;
import org.mapstruct.Named;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CommentMapper {

    CommentDto toDto(Comment comment);

    List<CommentDto> toDtos(List<Comment> comments);


    Comment toEntity(CommentDto commentDto, @Context Task task);

    @AfterMapping
    default void mapTask(@MappingTarget Comment comment,
                              CommentDto commentDto,
                              @Context Task task) {
        comment.setTask(task);
    }

}
