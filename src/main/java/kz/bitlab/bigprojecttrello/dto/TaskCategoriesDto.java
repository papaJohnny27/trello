package kz.bitlab.bigprojecttrello.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TaskCategoriesDto {
    private Long id;
    private String name;
}
