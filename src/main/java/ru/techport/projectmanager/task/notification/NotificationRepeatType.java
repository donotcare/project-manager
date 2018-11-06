package ru.techport.projectmanager.task.notification;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import java.util.stream.Stream;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
@Getter
public enum NotificationRepeatType {
    NONE("NONE", "Нет"), ONCE_AN_HOUR("ONCE_AN_HOUR", "Раз в час"), ONCE_A_DAY("ONCE_A_DAY", "Раз в час");
    private final String id;
    private final String name;

    NotificationRepeatType(String id, String name) {
        this.id = id;
        this.name = name;
    }

    @JsonCreator
    public static NotificationRepeatType of(@JsonProperty("id") String id) {
        return Stream.of(NotificationRepeatType.values()).filter(v -> v.id.equals(id)).findAny().orElseThrow();
    }
}
