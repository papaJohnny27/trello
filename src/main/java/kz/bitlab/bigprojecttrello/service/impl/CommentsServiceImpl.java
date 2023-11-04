package kz.bitlab.bigprojecttrello.service.impl;

import kz.bitlab.bigprojecttrello.dto.CommentsDto;
import kz.bitlab.bigprojecttrello.model.Comments;
import kz.bitlab.bigprojecttrello.model.Tasks;
import kz.bitlab.bigprojecttrello.repository.CommentsRepository;
import kz.bitlab.bigprojecttrello.repository.TasksRepository;
import kz.bitlab.bigprojecttrello.service.CommentsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CommentsServiceImpl implements CommentsService {
    private final CommentsRepository commentsRepository;
    private final TasksRepository tasksRepository;

    @Override
    public List<CommentsDto> getByTaskId(Long taskId) {
        return commentsRepository.findAllByTaskId(taskId).stream()
                .map(comments -> new CommentsDto(comments.getId(), comments.getComment()))
                .collect(Collectors.toList());
    }

    @Override
    public void create(Long taskId, CommentsDto commentsDto) {
        Tasks tasks = tasksRepository.findById(taskId).orElseThrow();
        commentsRepository.save(new Comments(null, commentsDto.getComment(), tasks));
    }

    @Override
    public void delete(Long id) {
        commentsRepository.deleteById(id);
    }
}
