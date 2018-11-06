package ru.techport.projectmanager.task.notification;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Immutable;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor
@Getter
@Immutable
public class Notification {
    @Id
    @GeneratedValue
    private Long id;
    private long taskId;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime startDate;
    @Enumerated(EnumType.STRING)
    private NotificationRepeatType repeatType;

    public static Notification of(long taskId, LocalDateTime startDate, NotificationRepeatType repeatType) {
        return new Notification(null, taskId, startDate, repeatType);
    }
}
