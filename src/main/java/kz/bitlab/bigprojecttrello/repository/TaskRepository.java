package kz.bitlab.bigprojecttrello.repository;

import kz.bitlab.bigprojecttrello.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task,Long> {
    @Query("select t from Task t where t.folder.id = :folderId ")
    List<Task> findAllByFolderId(Long folderId);

}
