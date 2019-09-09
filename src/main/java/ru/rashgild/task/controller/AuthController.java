package ru.rashgild.task.controller;

import java.io.IOException;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ru.rashgild.task.model.User;
import ru.rashgild.task.service.UserService;

@RestController
public class AuthController {

    @Autowired
    private UserService userService;

    @GetMapping(value = {"/login", "/"})
    public void login(@RequestParam("username") String username,
                      HttpServletResponse response) throws IOException {

        User user = userService.findUserByUsername(username);
        if (user != null) {
            response.sendRedirect("/doclist");
        } else {
            response.sendRedirect("/403");
        }

    }

    @GetMapping(value = "/403")
    public String accesssDenied() {
        return "access denied";
    }

    @GetMapping(value = "/404")
    public String notFound() {
        return "not found";
    }
}
