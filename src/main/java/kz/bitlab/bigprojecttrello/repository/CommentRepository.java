package kz.bitlab.bigprojecttrello.repository;

import kz.bitlab.bigprojecttrello.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment,Long> {

    @Query("select c from Comment c where c.task.id = :taskId")
    List<Comment> findAllByTaskId(Long taskId);
}
