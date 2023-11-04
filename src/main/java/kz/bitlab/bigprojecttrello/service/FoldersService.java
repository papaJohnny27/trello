package kz.bitlab.bigprojecttrello.service;

import kz.bitlab.bigprojecttrello.dto.FoldersDto;

import java.util.List;

public interface FoldersService {
    List<FoldersDto> getAll();

    FoldersDto getById(Long id);

    void create(FoldersDto foldersDto);


    void update(Long id,FoldersDto foldersDto);

    void delete(Long id);

    void deleteCategory(Long folderId,Long categoryId);

}

