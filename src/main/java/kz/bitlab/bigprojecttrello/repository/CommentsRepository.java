package kz.bitlab.bigprojecttrello.repository;

import kz.bitlab.bigprojecttrello.model.Comments;
import kz.bitlab.bigprojecttrello.model.Tasks;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentsRepository extends JpaRepository<Comments,Long> {

    @Query("select c from Comments c where c.task.id = :taskId")
    List<Comments> findAllByTaskId(Long taskId);
}
