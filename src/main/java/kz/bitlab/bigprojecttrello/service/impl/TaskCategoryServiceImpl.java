package kz.bitlab.bigprojecttrello.service.impl;

import kz.bitlab.bigprojecttrello.dto.TaskCategoryDto;
import kz.bitlab.bigprojecttrello.mapper.TaskCategoryMapper;
import kz.bitlab.bigprojecttrello.repository.TaskCategoryRepository;
import kz.bitlab.bigprojecttrello.service.TaskCategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskCategoryServiceImpl implements TaskCategoryService {

    private final TaskCategoryRepository taskCategoryRepository;
    private final TaskCategoryMapper taskCategoryMapper;

    @Override
    public List<TaskCategoryDto> getAll() {
        return taskCategoryMapper.toDtos(taskCategoryRepository.findAll());
    }
}
