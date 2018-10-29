package ru.techport.projectmanager.user;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor
@Entity
public class User {
    @Id
    @GeneratedValue
    private Long id;
    private String name;

    public static User of(String name) {
        return new User(null, name);
    }
}
