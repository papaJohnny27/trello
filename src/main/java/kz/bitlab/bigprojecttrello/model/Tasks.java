package kz.bitlab.bigprojecttrello.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "task")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class Tasks {
    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="tasks_seq")
    @SequenceGenerator(name = "tasks_seq", sequenceName = "task_id_seq", allocationSize = 1)
    Long id;
    String title;
    String description;
    @Enumerated(EnumType.ORDINAL)
    TaskStatus status;

    @ManyToOne
    @JoinColumn(name = "folder_id")
    private Folders folder;

    @OneToMany(mappedBy = "task")
    private Set<Comments> comments = new HashSet<>();
}
