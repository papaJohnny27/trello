package kz.bitlab.bigprojecttrello.service;

import kz.bitlab.bigprojecttrello.dto.FolderDto;

import java.util.List;

public interface FolderService {
    List<FolderDto> getAll();

    FolderDto getById(Long id);

    void create(FolderDto foldersDto);


    void update(Long id, FolderDto folderDto);

    void delete(Long id);

    void deleteCategory(Long folderId,Long categoryId);

}

