package ru.techport.projectmanager.task.message.web;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.techport.projectmanager.task.message.TaskMessage;
import ru.techport.projectmanager.task.message.TaskMessageService;

import java.util.Collection;

@RestController
@AllArgsConstructor
public class TaskMessageController {
    private final TaskMessageService service;

    @GetMapping("task/{id}/message")
    public Collection<TaskMessage> getMessagesByTaskId(@PathVariable("id") long taskId) {
        return service.getMessagesByTaskId(taskId);
    }

    @PostMapping("task/{id}/message")
    public void save(@PathVariable("id") long taskId, @RequestBody String text) {
        service.save(taskId, text);
    }
}
