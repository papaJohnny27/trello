package kz.bitlab.bigprojecttrello.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "task_category")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TaskCategory {
    @Id
    @GeneratedValue (strategy= GenerationType.SEQUENCE, generator="task_category_seq")
    @SequenceGenerator(name = "task_category_seq", sequenceName = "task_category_id_seq", allocationSize = 1)
    private Long id;
    private String name;

    @ManyToMany(mappedBy = "categories")
    private Set<Folder> folders = new HashSet<>();
}
