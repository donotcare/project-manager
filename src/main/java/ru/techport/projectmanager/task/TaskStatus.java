package ru.techport.projectmanager.task;

public enum TaskStatus {
    NEW("Новый"), ACTIVE("Активный");
    private final String name;

    TaskStatus(String name) {
        this.name = name;
    }
}
