package by.home.user.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * @author alek
 * @since 0.0.1
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
