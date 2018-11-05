package ru.techport.projectmanager.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor
@Entity
@Table(name = "Users")
public class User {
    @Id
    @GeneratedValue
    private Long id;
    @Column(unique = true)
    private String username;
    private String name;
    @JsonIgnore
    private String password;
    @JsonIgnore
    private boolean enabled;

    public static User of(String name, String username, String password) {
        return new User(null, username, name, password, true);
    }
}
