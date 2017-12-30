package by.home.user.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

/**
 * @author alek
 * @since 0.0.1
 */
@Data
public class Token {

    @Getter
    @Setter
    private String login;

    @Getter
    @Setter
    private String value;

    @Getter
    @Setter
    private LocalDate generationDate;

    public Token() {
        value = UUID.randomUUID().toString();
    }
}
