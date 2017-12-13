package by.home.user.model;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by alek on 14.12.17.
 */
public class Credentials {

    @Getter
    @Setter
    private String login;

    @Getter
    @Setter
    private String passwordHash;

}
