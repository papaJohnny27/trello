package kz.bitlab.bigprojecttrello.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FolderDto {

    private Long id;
    private String name;
    private List<TaskCategoryDto> categories;
}
