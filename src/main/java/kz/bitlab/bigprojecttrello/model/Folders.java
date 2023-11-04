package kz.bitlab.bigprojecttrello.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "folder")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Folders {
    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="folder_seq")
    @SequenceGenerator(name = "folder_seq", sequenceName = "folder_id_seq", allocationSize = 1)
    private Long id;
    private String name;
    @ManyToMany
    @JoinTable(
            name = "folder_task_category",
            joinColumns = {@JoinColumn(name = "folder_id")},
            inverseJoinColumns = {@JoinColumn(name = "task_category_id")}
    )
    private Set<TaskCategories> categories = new HashSet<>();
    @OneToMany(mappedBy = "folder")
    private Set<Tasks> tasks = new HashSet<>();
}
