package ru.techport.projectmanager.task.notification.event;

import lombok.Getter;
import ru.techport.projectmanager.task.notification.Notification;

@Getter
public class NotificationSavedEvent{
    private final Notification notification;

    public NotificationSavedEvent(Notification notification) {
        this.notification = notification;
    }
}
