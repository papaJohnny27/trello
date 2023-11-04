package kz.bitlab.bigprojecttrello.service;

import kz.bitlab.bigprojecttrello.dto.CommentsDto;

import java.util.List;

public interface CommentsService {
    List<CommentsDto> getByTaskId(Long taskId);

    void create(Long taskId, CommentsDto commentsDto);

    void delete(Long id);
}
