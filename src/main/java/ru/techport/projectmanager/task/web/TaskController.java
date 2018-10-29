package ru.techport.projectmanager.task.web;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.techport.projectmanager.task.Task;
import ru.techport.projectmanager.task.TaskService;

import java.util.Collection;

@RestController
@AllArgsConstructor
public class TaskController {
    private final TaskService taskService;

    @GetMapping("task")
    public Collection<Task> getTasks(@RequestParam(name = "receiver", required = false) Integer receiverId) {
        if(receiverId != null) {
            return taskService.getTasksByReceiver(receiverId);
        } else {
            return taskService.getTasks();
        }
    }


    @GetMapping("task/{id}")
    public Task getTask(@PathVariable("id") long id) {
        return taskService.getTaskById(id);

    }

    @PutMapping("task/{id}")
    public void saveTask(@PathVariable("id") long id, @RequestBody Task task) {
        taskService.save(task);
    }
}
