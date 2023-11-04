package kz.bitlab.bigprojecttrello.repository;

import kz.bitlab.bigprojecttrello.model.Folders;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FoldersRepository extends JpaRepository<Folders,Long> {

    @Modifying
    @Query(value = "delete from folder_task_category " +
            " where folder_id = :folderId and task_category_id = :categoryId",
            nativeQuery = true)
    void deleteCategory(Long folderId,Long categoryId);
}
