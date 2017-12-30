package by.home.user.controller;

import by.home.user.model.User;
import by.home.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by alek on 31.12.17.
 */
@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/user")
    public User getUserInfo(@RequestParam("id") String id) {
        return userService.getUserByIdentifier(id);
    }

    @PostMapping("/user")
    public String saveUserInfo(@RequestParam("id") String id) {
        return "0";
    }

}
