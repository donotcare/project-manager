package ru.techport.projectmanager;

import lombok.AllArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import ru.techport.projectmanager.task.Task;
import ru.techport.projectmanager.task.TaskService;
import ru.techport.projectmanager.task.TaskStatus;
import ru.techport.projectmanager.user.User;
import ru.techport.projectmanager.user.UserService;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class AppInit {
    private final TaskService taskService;
    private final UserService userService;

    @EventListener
    public void init(ApplicationReadyEvent event) {
        User firstUser = User.of("Иванов Иван");
        User secondUser = User.of("Петров Петр");
        userService.save(firstUser);
        userService.save(secondUser);

        Task firstTask = Task.of("Доставить накладную", TaskStatus.NEW, firstUser, secondUser, LocalDateTime.now());
        Task secondTask = Task.of("Доставить накладную", TaskStatus.NEW, firstUser, firstUser, LocalDateTime.now());
        taskService.save(firstTask);
        taskService.save(secondTask);
    }
}
