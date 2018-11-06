package ru.techport.projectmanager.task.event;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import ru.techport.projectmanager.task.Task;
import ru.techport.projectmanager.task.notification.Notification;

import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class TaskSavedEvent {
    private Task task;
    private List<Notification> notifications;

}
