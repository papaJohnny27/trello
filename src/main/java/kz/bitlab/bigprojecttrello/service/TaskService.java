package kz.bitlab.bigprojecttrello.service;

import kz.bitlab.bigprojecttrello.dto.TaskDto;

import java.util.List;

public interface TaskService {
    List<TaskDto> getAllByFolderId(Long folderId);

}
