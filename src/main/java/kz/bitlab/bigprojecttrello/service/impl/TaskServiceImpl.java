package kz.bitlab.bigprojecttrello.service.impl;

import kz.bitlab.bigprojecttrello.dto.TaskDto;
import kz.bitlab.bigprojecttrello.mapper.TaskMapper;
import kz.bitlab.bigprojecttrello.model.Task;
import kz.bitlab.bigprojecttrello.repository.TaskRepository;
import kz.bitlab.bigprojecttrello.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;
    private final TaskMapper taskMapper;

    @Override
    public List<TaskDto> getAllByFolderId(Long folderId) {
        List<Task> tasks = taskRepository.findAllByFolderId(folderId);
        return taskMapper.toDtos(tasks);
    }
}
