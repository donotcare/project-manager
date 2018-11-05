package ru.techport.projectmanager.user.web;

import lombok.AllArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.techport.projectmanager.user.User;
import ru.techport.projectmanager.user.UserService;

import java.util.List;

@RestController
@AllArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/api/user")
    public List<User> getUsers() {
        return userService.getAll();
    }

    @GetMapping("/api/username")
    public String getCurrentUserName(@AuthenticationPrincipal UserDetails user) {
        if(user == null) {
            return "Неизвестно";
        } else {
            return user.getUsername();
        }
    }
}
