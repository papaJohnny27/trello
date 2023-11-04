package kz.bitlab.bigprojecttrello.service.impl;

import jakarta.transaction.Transactional;
import kz.bitlab.bigprojecttrello.dto.FoldersDto;
import kz.bitlab.bigprojecttrello.dto.TaskCategoriesDto;
import kz.bitlab.bigprojecttrello.mapper.FolderMapper;
import kz.bitlab.bigprojecttrello.model.Folders;
import kz.bitlab.bigprojecttrello.model.TaskCategories;
import kz.bitlab.bigprojecttrello.repository.FoldersRepository;
import kz.bitlab.bigprojecttrello.service.FoldersService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FoldersServiceImpl implements FoldersService {

    private final FoldersRepository foldersRepository;

    @Override
    public List<FoldersDto> getAll() {
        List<Folders> folders = foldersRepository.findAll();

        return FolderMapper.toDtos(folders);
    }

    @Override
    public FoldersDto getById(Long id) {
        return foldersRepository.findById(id)
                .map(FolderMapper::toDto)
                .orElseThrow();

    }

    @Override
    public void create(FoldersDto foldersDto) {
        foldersRepository.save(FolderMapper.toEntity(foldersDto));
    }

    @Override
    public void update(Long id, FoldersDto foldersDto) {
        Folders folders = foldersRepository.findById(id).orElseThrow();
        folders.setName(foldersDto.getName());
        folders.setCategories(foldersDto.getCategories().stream()
                .map(category -> new TaskCategories(category.getId(), category.getName(), new HashSet<>())).collect(Collectors.toSet()));

        foldersRepository.save(folders);
    }

    @Override
    public void delete(Long id) {
        foldersRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void deleteCategory(Long folderId, Long categoryId) {
        foldersRepository.deleteCategory(folderId, categoryId);
    }
}
