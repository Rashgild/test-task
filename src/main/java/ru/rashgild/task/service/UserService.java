package ru.rashgild.task.service;

import ru.rashgild.task.model.User;

public interface UserService {

    User findUserByUsername(String username);
}
