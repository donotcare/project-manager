package ru.techport.projectmanager.task.notification;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class NotificationService {
    private final NotificationRepository notificationRepository;
    private final int MAX_TASK_NOTIFICATION_SIZE = 5;

    public void saveNotification(Notification notification) {
        notificationRepository.save(notification);
    }

    public List<Notification> getNotificationsByTaskId(long taskId) {
        return notificationRepository.getNotificationsByTaskId(taskId);
    }

    @Transactional
    public void saveTaskNotifications(long taskId, List<Notification> notifications) {
        if(notifications.size() > MAX_TASK_NOTIFICATION_SIZE) {
            throw new IllegalArgumentException("Не может быть больше 5 уведомлений");
        }
        saveNewNotifications(taskId, notifications);
        deleteNotifications(taskId, notifications);
    }

    private void deleteNotifications(long taskId, List<Notification> notifications) {
        List<Notification> currentNotifications = getNotificationsByTaskId(taskId);
        List<Notification> notificationsToDelete = currentNotifications.stream().filter(c -> !notifications.contains(c)).collect(Collectors.toList());
        if(!notificationsToDelete.isEmpty()) {
            notificationRepository.deleteAll(notificationsToDelete);
        }
    }

    private void saveNewNotifications(long taskId, List<Notification> notifications) {
        if(notifications.isEmpty()) {
            return;
        }
        List<Notification> newNotifications = notifications.stream().filter(n -> n.getId() == null && n.getTaskId() == taskId).collect(Collectors.toList());
        notificationRepository.saveAll(newNotifications);
    }
}
