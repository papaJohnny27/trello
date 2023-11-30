package kz.bitlab.bigprojecttrello.service;

import kz.bitlab.bigprojecttrello.dto.CommentDto;

import java.util.List;

public interface CommentService {
    List<CommentDto> getByTaskId(Long taskId);

    void create(Long taskId, CommentDto commentDto);

    void delete(Long id);
}
