package kz.bitlab.bigprojecttrello.service.impl;

import jakarta.transaction.Transactional;
import kz.bitlab.bigprojecttrello.dto.FolderDto;
import kz.bitlab.bigprojecttrello.mapper.FolderMapper;
import kz.bitlab.bigprojecttrello.model.Folder;
import kz.bitlab.bigprojecttrello.model.TaskCategory;
import kz.bitlab.bigprojecttrello.repository.FolderRepository;
import kz.bitlab.bigprojecttrello.service.FolderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FolderServiceImpl implements FolderService {

    private final FolderRepository folderRepository;

    @Override
    public List<FolderDto> getAll() {
        List<Folder> folders = folderRepository.findAll();

        return FolderMapper.toDtos(folders);
    }

    @Override
    public FolderDto getById(Long id) {
        return folderRepository.findById(id)
                .map(FolderMapper::toDto)
                .orElseThrow();

    }

    @Override
    public void create(FolderDto foldersDto) {
        folderRepository.save(FolderMapper.toEntity(foldersDto));
    }

    @Override
    public void update(Long id, FolderDto foldersDto) {
        Folder folder = folderRepository.findById(id).orElseThrow();
        folder.setName(foldersDto.getName());
        folder.setCategories(foldersDto.getCategories().stream()
                .map(category -> new TaskCategory(category.getId(), category.getName(), new HashSet<>())).collect(Collectors.toSet()));

        folderRepository.save(folder);
    }

    @Override
    public void delete(Long id) {
        folderRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void deleteCategory(Long folderId, Long categoryId) {
        folderRepository.deleteCategory(folderId, categoryId);
    }
}
