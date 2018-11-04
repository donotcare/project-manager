package ru.techport.projectmanager;

import lombok.AllArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.techport.projectmanager.task.Task;
import ru.techport.projectmanager.task.TaskService;
import ru.techport.projectmanager.task.TaskStatus;
import ru.techport.projectmanager.user.User;
import ru.techport.projectmanager.user.UserService;
import ru.techport.projectmanager.user.role.UserRole;
import ru.techport.projectmanager.user.role.UserRoleRepository;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class AppInit {
    private final TaskService taskService;
    private final UserService userService;
    private final UserRoleRepository userRoleRepository;
    private final PasswordEncoder passwordEncoder;

    @EventListener
    public void init(ApplicationReadyEvent event) {
        UserRole userRole = UserRole.of("ivanov", "USER");
        userRoleRepository.save(userRole);
        User firstUser = User.of("Иванов Иван", "ivanov", passwordEncoder.encode("111"));
        User secondUser = User.of("Петров Петр", "petrov", passwordEncoder.encode("111"));
        userService.save(firstUser);
        userService.save(secondUser);

        Task firstTask = Task.of("Доставить накладную", TaskStatus.NEW, firstUser, secondUser, LocalDateTime.now());
        Task secondTask = Task.of("Доставить накладную", TaskStatus.NEW, firstUser, firstUser, LocalDateTime.now());
        taskService.save(firstTask);
        taskService.save(secondTask);
    }
}
