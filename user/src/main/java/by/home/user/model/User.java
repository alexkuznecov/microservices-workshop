package by.home.user.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * @author alek
 * @since 0.0.1
 */
@Data
public class User {

    @Getter
    @Setter
    private String name;

    @Getter
    @Setter
    private String surname;

    @Getter
    @Setter
    private String email;

    @Getter
    @Setter
    private String login;

    public User(String login) {
        this.name = "default";
        this.surname = "default";
        this.email = "default@test.te";
        this.login = login;
    }
}
