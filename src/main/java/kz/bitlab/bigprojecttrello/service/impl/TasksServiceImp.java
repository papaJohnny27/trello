package kz.bitlab.bigprojecttrello.service.impl;

import kz.bitlab.bigprojecttrello.dto.TasksDto;
import kz.bitlab.bigprojecttrello.model.Tasks;
import kz.bitlab.bigprojecttrello.repository.TasksRepository;
import kz.bitlab.bigprojecttrello.service.TasksService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class TasksServiceImp implements TasksService {

    private final TasksRepository tasksRepository;

    @Override
    public List<TasksDto> getAllByFolderId(Long folderId) {
        List<Tasks> tasks = tasksRepository.findAllByFolderId(folderId);
        return tasks.stream()
                .map(tasks1 -> new TasksDto(tasks1.getId(), tasks1.getTitle(), tasks1.getDescription(), tasks1.getStatus())).collect(Collectors.toList());
    }
}
