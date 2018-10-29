package ru.techport.projectmanager.task;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

public interface TaskRepository extends JpaRepository<Task, Long> {
    public Collection<Task> getTaskByReceiverId(long userId);
}
