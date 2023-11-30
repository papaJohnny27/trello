package kz.bitlab.bigprojecttrello.service.impl;

import kz.bitlab.bigprojecttrello.dto.TaskDto;
import kz.bitlab.bigprojecttrello.model.Task;
import kz.bitlab.bigprojecttrello.repository.TaskRepository;
import kz.bitlab.bigprojecttrello.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;

    @Override
    public List<TaskDto> getAllByFolderId(Long folderId) {
        List<Task> tasks = taskRepository.findAllByFolderId(folderId);
        return tasks.stream()
                .map(tasks1 -> new TaskDto(tasks1.getId(), tasks1.getTitle(), tasks1.getDescription(), tasks1.getStatus())).collect(Collectors.toList());
    }
}
