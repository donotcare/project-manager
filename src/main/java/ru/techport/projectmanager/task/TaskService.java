package ru.techport.projectmanager.task;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.techport.projectmanager.task.event.TaskSavedEvent;
import ru.techport.projectmanager.task.notification.Notification;
import ru.techport.projectmanager.task.notification.NotificationService;

import java.util.Collection;
import java.util.List;

@Service
@AllArgsConstructor
public class TaskService {
    private final TaskRepository taskRepository;
    private final NotificationService notificationService;

    @Transactional
    public void save(TaskSavedEvent taskSavedEvent) {
        Task task = taskSavedEvent.getTask();
        taskRepository.save(task);
        List<Notification> notifications = taskSavedEvent.getNotifications();
        notificationService.saveTaskNotifications(task.getId(), notifications);
    }

    public void save(Task task) {
        taskRepository.save(task);
    }

    public Task getTaskById(long id) {
        return taskRepository.findById(id).orElse(null);
    }

    public Collection<Task> getTasksByReceiver(long userId) {
        return taskRepository.getTaskByReceiverId(userId);
    }

    public Collection<Task> getTasks(Integer receiverId) {
        if (receiverId != null) {
            return getTasksByReceiver(receiverId);
        } else {
            return taskRepository.findAll();
        }
    }

    public List<Notification> getTaskNotifications(long id) {
        return notificationService.getNotificationsByTaskId(id);
    }
}
