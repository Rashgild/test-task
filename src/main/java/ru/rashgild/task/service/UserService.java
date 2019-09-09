package ru.rashgild.task.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.transaction.annotation.Transactional;

import ru.rashgild.task.model.User;

public interface UserService {
    User findUserByUsername(String username);

    @Transactional(readOnly = true)
    UserDetails loadUserByUsername(String username);
}
