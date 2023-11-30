package kz.bitlab.bigprojecttrello.service.impl;

import kz.bitlab.bigprojecttrello.dto.TaskCategoryDto;
import kz.bitlab.bigprojecttrello.repository.TaskCategoryRepository;
import kz.bitlab.bigprojecttrello.service.TaskCategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TaskCategoryServiceImpl implements TaskCategoryService {
    private final TaskCategoryRepository taskCategoryRepository;
    @Override
    public List<TaskCategoryDto> getAll() {
        return taskCategoryRepository.findAll().stream()
                .map(t-> new TaskCategoryDto(t.getId(), t.getName()))
                .collect(Collectors.toList());
    }
}
