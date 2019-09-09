package ru.rashgild.task.controller;

import java.io.IOException;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ru.rashgild.task.model.User;
import ru.rashgild.task.service.UserService;

@RestController
public class AuthController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = {"/login", "/"}, method = RequestMethod.GET)
    public void login(@RequestParam("username") String username,
                      HttpServletResponse response) throws IOException {
        User user = userService.findUserByUsername(username);
        if (user != null) {
            response.sendRedirect("/doclist");
        } else {
            response.sendRedirect(null);
        }
    }
}
