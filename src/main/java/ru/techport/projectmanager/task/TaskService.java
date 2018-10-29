package ru.techport.projectmanager.task;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
@AllArgsConstructor
public class TaskService {
    private final TaskRepository taskRepository;

    public void save(Task task) {
        taskRepository.save(task);
    }

    public Task getTaskById(long id) {
        return taskRepository.findById(id).orElse(null);
    }

    public Collection<Task> getTasksByReceiver(long userId) {
        return taskRepository.getTaskByReceiverId(userId);
    }

    public Collection<Task> getTasks() {
        return taskRepository.findAll();
    }
}
