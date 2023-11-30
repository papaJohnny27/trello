package kz.bitlab.bigprojecttrello.mapper;

import kz.bitlab.bigprojecttrello.dto.FolderDto;
import kz.bitlab.bigprojecttrello.dto.TaskCategoryDto;
import kz.bitlab.bigprojecttrello.model.Folder;
import kz.bitlab.bigprojecttrello.model.TaskCategory;

import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class FolderMapper {
    public static FolderDto toDto(Folder folder) {
        return new FolderDto(folder.getId(), folder.getName(), folder.getCategories().stream()
                .map(category -> new TaskCategoryDto(category.getId(), category.getName())).collect(Collectors.toList()));
    }

    public static List<FolderDto> toDtos(List<Folder> folders) {
        return folders.stream().map(FolderMapper::toDto).collect(Collectors.toList());
    }

    public static Folder toEntity(FolderDto foldersDto) {
        return new Folder(
                null,
                foldersDto.getName(),
                foldersDto.getCategories() != null ? foldersDto.getCategories().stream()
                        .map(e -> new TaskCategory(e.getId(), e.getName(), new HashSet<>()))
                        .collect(Collectors.toSet()) : new HashSet<>(), new HashSet<>());
    }
}


