package by.home.user.controller;

import by.home.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author alek
 * @since 0.0.1
 */
@RestController
@RequestMapping("/api/auth")
public class AuthorizeController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public String login(
            @RequestParam String login,
            @RequestParam String password
    ) {
        try {
            return userService.login(login,password);
        } catch (Exception e) {
            return "403";
        }
    }

    @PostMapping("/logout")
    public String logout() {
        return "logout successful";
    }

}
