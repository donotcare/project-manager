package ru.techport.projectmanager.user.role;

import lombok.AllArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user_roles")
@AllArgsConstructor
public class UserRole {
    @Id
    @GeneratedValue
    private Long id;
    private String username;
    private String role;

    public static UserRole of(String name, String role) {
        return new UserRole(null, name, role);
    }
}
