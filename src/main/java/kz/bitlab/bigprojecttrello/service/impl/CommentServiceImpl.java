package kz.bitlab.bigprojecttrello.service.impl;

import kz.bitlab.bigprojecttrello.dto.CommentDto;
import kz.bitlab.bigprojecttrello.model.Comment;
import kz.bitlab.bigprojecttrello.model.Task;
import kz.bitlab.bigprojecttrello.repository.CommentRepository;
import kz.bitlab.bigprojecttrello.repository.TaskRepository;
import kz.bitlab.bigprojecttrello.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {
    private final CommentRepository commentRepository;
    private final TaskRepository taskRepository;

    @Override
    public List<CommentDto> getByTaskId(Long taskId) {
        return commentRepository.findAllByTaskId(taskId).stream()
                .map(comment -> new CommentDto(comment.getId(), comment.getComment()))
                .collect(Collectors.toList());
    }

    @Override
    public void create(Long taskId, CommentDto commentDto) {
        Task task = taskRepository.findById(taskId).orElseThrow();
        commentRepository.save(new Comment(null, commentDto.getComment(), task));
    }

    @Override
    public void delete(Long id) {
        commentRepository.deleteById(id);
    }
}
