package kz.bitlab.bigprojecttrello.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FoldersDto {

    private Long id;
    private String name;

    private List<TaskCategoriesDto> categories;
}
