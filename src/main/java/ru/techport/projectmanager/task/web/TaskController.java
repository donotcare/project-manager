package ru.techport.projectmanager.task.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.techport.projectmanager.task.Task;

import java.util.Arrays;
import java.util.Collection;

@RestController
public class TaskController {
    @GetMapping("task")
    public Collection<Task> getTasks() {
        return Arrays.asList(Task.of(1L, "Позвонить на склад"), Task.of(2L, "Передать накладную"),
                Task.of(4L, "Позвонить на склад"), Task.of(6L, "Передать накладную"),
                Task.of(5L, "Позвонить на склад"), Task.of(7L, "Передать накладную"));
    }
}
