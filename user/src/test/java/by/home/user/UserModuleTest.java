package by.home.user;

import by.home.user.model.User;
import by.home.user.repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by alek on 12.12.17.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserModuleTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void contextLoads() {

    }

    @Test
    public void insertUser() {
        User user = new User("sasha");
        user.setName("user1");
        user.setSurname("user1");
        user.setEmail("user@user.us");

        userRepository.save(user);
    }

}
