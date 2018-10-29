package ru.techport.projectmanager.task;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import ru.techport.projectmanager.user.User;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor
@Entity
public class Task {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    @Enumerated(EnumType.STRING)
    private TaskStatus status;
    @OneToOne
    @JoinColumn(nullable = false)
    private User author;
    @OneToOne
    @JoinColumn(nullable = false)
    private User receiver;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm")
    private LocalDateTime created;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm")
    private LocalDateTime taskDate;

    public static Task of(String name, TaskStatus status, User author, User receiver, LocalDateTime taskDate) {
        return new Task(null, name, status, author, receiver, LocalDateTime.now(), taskDate);
    }
}
