package ru.techport.projectmanager.task;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Task {
    private final long id;
    private final String name;

    public static Task of(long id, String name) {
        return new Task(id, name);
    }
}
