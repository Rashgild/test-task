package ru.rashgild.task.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ru.rashgild.task.model.Role;

@Repository("RoleDao")
@Transactional
public class RoleDaoImpl extends DaoImpl<Role> implements RoleDao {

    public RoleDaoImpl() {
        super(Role.class);
    }
}
