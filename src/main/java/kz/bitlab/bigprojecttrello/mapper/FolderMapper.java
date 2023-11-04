package kz.bitlab.bigprojecttrello.mapper;

import kz.bitlab.bigprojecttrello.dto.FoldersDto;
import kz.bitlab.bigprojecttrello.dto.TaskCategoriesDto;
import kz.bitlab.bigprojecttrello.model.Folders;
import kz.bitlab.bigprojecttrello.model.TaskCategories;

import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class FolderMapper {
    public static FoldersDto toDto(Folders folders) {
        return new FoldersDto(folders.getId(), folders.getName(), folders.getCategories().stream()
                .map(category -> new TaskCategoriesDto(category.getId(), category.getName())).collect(Collectors.toList()));
    }

    public static List<FoldersDto> toDtos(List<Folders> folders) {
        return folders.stream().map(FolderMapper::toDto).collect(Collectors.toList());
    }

    public static Folders toEntity(FoldersDto foldersDto) {
        return new Folders(
                null,
                foldersDto.getName(),
                foldersDto.getCategories() != null ? foldersDto.getCategories().stream()
                        .map(e -> new TaskCategories(e.getId(), e.getName(), new HashSet<>()))
                        .collect(Collectors.toSet()) : new HashSet<>(), new HashSet<>());
    }
}


