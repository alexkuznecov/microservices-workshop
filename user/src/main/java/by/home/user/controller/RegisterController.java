package by.home.user.controller;

import by.home.user.exceptions.LoginAlreadyExistException;
import by.home.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by alek on 14.12.17.
 */
@RestController
@RequestMapping("/api/user")
public class RegisterController {

    @Autowired
    private UserService userService;

    @PostMapping("/reg")
    public String registerUser(
            @RequestParam String login,
            @RequestParam String password
    ) {
        try {
            userService.registerUser(login, password);
            return "200";
        } catch (LoginAlreadyExistException e) {
            return e.getMessage();
        } catch (Exception e) {
            return "500";
        }
    }

}
