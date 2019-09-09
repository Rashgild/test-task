package ru.rashgild.task.service;


import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ru.rashgild.task.dao.UserDao;
import ru.rashgild.task.model.Role;
import ru.rashgild.task.model.User;

@Service("UserService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public User findUserByUsername(String username) {
        return userDao.findByUsername(username);
    }

    @Transactional(readOnly = true)
    @Override
    public UserDetails loadUserByUsername(String username) {
        User user = this.findUserByUsername(username);
        //user.setName("Admin");
        if (user != null) {
            String password = user.getPassword();
            //boolean enabled = user.getActive();
            //boolean accountNonExpired = user.getActive();
            //boolean credentialsNonExpired = user.getActive();
            //boolean accountNonLocked = user.getActive();

            Collection<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
            for (Role r : user.getRoles()) {
                authorities.add(new SimpleGrantedAuthority(r.getRole()));
            }
            org.springframework.security.core.userdetails.User securedUser = new org.springframework.security.core.userdetails.User(
                    username, password, authorities);
            return securedUser;
        } else {
            throw new UsernameNotFoundException(
                    "Unable to find user with username provided!!");
        }
    }
}
