package kz.bitlab.bigprojecttrello.service;

import kz.bitlab.bigprojecttrello.dto.TasksDto;
import kz.bitlab.bigprojecttrello.model.Folders;
import kz.bitlab.bigprojecttrello.model.Tasks;

import java.util.List;

public interface TasksService {
    List<TasksDto> getAllByFolderId(Long folderId);

}
