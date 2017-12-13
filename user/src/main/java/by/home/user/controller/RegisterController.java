package by.home.user.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by alek on 14.12.17.
 */
@RestController
@RequestMapping("/api/user")
public class RegisterController {

    @RequestMapping("/reg")
    public String registerUser() {
        return "success";
    }

}
