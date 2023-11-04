package kz.bitlab.bigprojecttrello.service.impl;

import kz.bitlab.bigprojecttrello.dto.TaskCategoriesDto;
import kz.bitlab.bigprojecttrello.repository.TaskCategoriesRepository;
import kz.bitlab.bigprojecttrello.service.TaskCategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TaskCategoryServiceImpl implements TaskCategoryService {
    private final TaskCategoriesRepository taskCategoriesRepository;
    @Override
    public List<TaskCategoriesDto> getAll() {
        return taskCategoriesRepository.findAll().stream()
                .map(t-> new TaskCategoriesDto(t.getId(), t.getName()))
                .collect(Collectors.toList());
    }
}
