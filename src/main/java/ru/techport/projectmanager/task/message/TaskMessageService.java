package ru.techport.projectmanager.task.message;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.techport.projectmanager.user.UserService;

import java.util.Collection;

@Service
@AllArgsConstructor
public class TaskMessageService {
    private final TaskMessageRepository repository;
    private final UserService userService;

    public Collection<TaskMessage> getMessagesByTaskId(long taskId) {
        return repository.getMessagesByTaskId(taskId);
    }

    public void save(long taskId, String text) {
        TaskMessage newMessage = TaskMessage.of(taskId, userService.getById(1), text);
        repository.save(newMessage);
    }
}
