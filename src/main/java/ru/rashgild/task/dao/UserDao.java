package ru.rashgild.task.dao;

import ru.rashgild.task.model.User;

public interface UserDao extends Dao<User> {
    User findByUsername(String username);
}
