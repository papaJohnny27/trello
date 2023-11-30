package kz.bitlab.bigprojecttrello.mapper;

import kz.bitlab.bigprojecttrello.dto.FolderDto;
import kz.bitlab.bigprojecttrello.model.Folder;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface FolderMapper {


    FolderDto toDto(Folder folder);

    List<FolderDto> toDtos(List<Folder> folders);

    Folder toEntity(FolderDto folderDto);
}
