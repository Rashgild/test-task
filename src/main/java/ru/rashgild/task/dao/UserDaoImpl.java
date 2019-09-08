package ru.rashgild.task.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ru.rashgild.task.model.User;

@Repository("UserDao")
@Transactional
public class UserDaoImpl extends DaoImpl<User> implements UserDao {

    public UserDaoImpl() {
        super(User.class);
    }
}
