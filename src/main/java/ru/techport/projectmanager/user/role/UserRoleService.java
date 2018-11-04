package ru.techport.projectmanager.user.role;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserRoleService {
    private final UserRoleRepository userRepository;

    public UserRole getById(long id) {
        return userRepository.findById(id).orElse(null);
    }

    public void save(UserRole role) {
        userRepository.save(role);
    }

    public List<UserRole> getAll() {
        return userRepository.findAll();
    }
}
