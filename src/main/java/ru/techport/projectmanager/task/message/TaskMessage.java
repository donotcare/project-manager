package ru.techport.projectmanager.task.message;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Immutable;
import org.springframework.format.annotation.DateTimeFormat;
import ru.techport.projectmanager.user.User;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Immutable
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class TaskMessage {
    @Id
    @GeneratedValue
    private Long id;
    private long taskId;
    @OneToOne
    @JoinColumn(nullable = false)
    private User author;
    private String text;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm")
    private LocalDateTime created;

    public static TaskMessage of(long taskId, User author, String text) {
        return new TaskMessage(null, taskId, author, text, LocalDateTime.now());
    }
}
