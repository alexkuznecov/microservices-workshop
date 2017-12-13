package by.home.user.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by alek on 14.12.17.
 */
@RestController
@RequestMapping("/api/auth")
public class AuthorizeController {

    @RequestMapping("/login")
    public String login() {
        return "login succesful";
    }

    @RequestMapping("/logout")
    public String logout() {
        return "logout successful";
    }

}
