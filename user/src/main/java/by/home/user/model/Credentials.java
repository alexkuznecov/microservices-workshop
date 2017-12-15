package by.home.user.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by alek on 14.12.17.
 */
@Data
public class Credentials {

    @Getter
    @Setter
    private String login;

    @Getter
    @Setter
    private String passwordHash;

}
