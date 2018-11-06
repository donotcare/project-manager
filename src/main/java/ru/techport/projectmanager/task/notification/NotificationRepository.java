package ru.techport.projectmanager.task.notification;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NotificationRepository extends JpaRepository<Notification, Long> {
    List<Notification> getNotificationsByTaskId(long taskId);
}
