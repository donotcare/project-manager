package ru.techport.projectmanager.task.message;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

public interface TaskMessageRepository extends JpaRepository<TaskMessage, Long> {
    Collection<TaskMessage> getMessagesByTaskId(long taskId);
}
