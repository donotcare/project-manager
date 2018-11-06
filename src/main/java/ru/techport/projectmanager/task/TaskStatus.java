package ru.techport.projectmanager.task;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import java.util.stream.Stream;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
@Getter
public enum TaskStatus {
    NEW("NEW", "Новая"), ACTIVE("ACTIVE", "Активная");

    private final String id;
    private final String name;

    TaskStatus(String id, String name) {
        this.id = id;
        this.name = name;
    }

    @JsonCreator
    public static TaskStatus of(@JsonProperty("id") String id) {
        return Stream.of(TaskStatus.values()).filter(v -> v.id.equals(id)).findAny().orElseThrow();
    }
}
