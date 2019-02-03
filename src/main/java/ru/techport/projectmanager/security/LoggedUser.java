package ru.techport.projectmanager.security;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.security.core.userdetails.User;

import java.util.Collections;
import java.util.List;

@AllArgsConstructor
@Getter
public class LoggedUser {
    private String username;
    private List<String> roles;

    public static LoggedUser of(User user) {
        if (user == null) {
            return null;
        }
        return new LoggedUser(user.getUsername(), Collections.emptyList());
    }

}
