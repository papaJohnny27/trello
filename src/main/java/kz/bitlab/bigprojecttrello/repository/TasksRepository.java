package kz.bitlab.bigprojecttrello.repository;

import kz.bitlab.bigprojecttrello.model.Tasks;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TasksRepository extends JpaRepository<Tasks,Long> {
    @Query("select t from Tasks t where t.folder.id = :folderId ")
    List<Tasks> findAllByFolderId(Long folderId);

}
