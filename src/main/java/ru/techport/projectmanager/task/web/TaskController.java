package ru.techport.projectmanager.task.web;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.techport.projectmanager.task.Task;
import ru.techport.projectmanager.task.TaskService;
import ru.techport.projectmanager.task.event.TaskSavedEvent;
import ru.techport.projectmanager.task.notification.Notification;

import java.util.Collection;
import java.util.List;

@RestController
@AllArgsConstructor
public class TaskController {
    private final TaskService taskService;

    @GetMapping("/api/task")
    public Collection<Task> getTasks(@RequestParam(name = "receiver", required = false) Integer receiverId) {
        return taskService.getTasks(receiverId);
    }

    @GetMapping("/api/task/{id}")
    public Task getTask(@PathVariable("id") long id) {
        return taskService.getTaskById(id);
    }

    @GetMapping("/api/task/{id}/notification")
    public List<Notification> getTaskNotifications(@PathVariable("id") long id) {
        return taskService.getTaskNotifications(id);
    }

    @PutMapping("/api/task/{id}")
    public void saveTask(@PathVariable("id") long id, @RequestBody TaskSavedEvent taskSavedEvent) {
        taskService.save(taskSavedEvent);
    }

    @PostMapping("/api/task/")
    public void createTask(@RequestBody TaskSavedEvent taskSavedEvent) {
        taskService.save(taskSavedEvent);
    }
}
