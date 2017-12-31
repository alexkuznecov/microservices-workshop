package by.home.user.service.impl;

import by.home.user.exceptions.LoginAlreadyExistException;
import by.home.user.exceptions.UnauthorizedUserException;
import by.home.user.exceptions.UserNotFoundException;
import by.home.user.model.Credentials;
import by.home.user.model.Token;
import by.home.user.model.User;
import by.home.user.repository.CredentialsRepository;
import by.home.user.repository.TokenRepository;
import by.home.user.repository.UserRepository;
import by.home.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

/**
 * @author alek
 * @since 0.0.1
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private CredentialsRepository credentialsRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private TokenRepository tokenRepository;

    @Autowired
    private UserRepository userRepository;

    public String login(String login, String password) throws UnauthorizedUserException, UserNotFoundException {
        List<Credentials> credentials = credentialsRepository.findByLogin(login);
        if (credentials != null && credentials.size() != 0) {
            if (passwordEncoder.matches(password, credentials.get(0).getPasswordHash())) {
                Token token = new Token();
                token.setLogin(login);
                token.setGenerationDate(LocalDate.now());
                token.setValue(token.getValue());
                tokenRepository.insert(token);
                return token.getValue();
            } else {
                throw new UnauthorizedUserException("Invalid password for user with login " + login);
            }
        } else {
            throw new UserNotFoundException("User with login " + login + " not found");
        }
    }

    public void registerUser(String login, String password) throws LoginAlreadyExistException {
        List<Credentials> credentials = credentialsRepository.findByLogin(login);
        if (credentials != null && credentials.size() != 0) {
            throw new LoginAlreadyExistException("User with login " + login + " already registered");
        } else {
            String encodedPassword = passwordEncoder.encode(password);

            Credentials userCredentials = new Credentials();
            userCredentials.setLogin(login);
            userCredentials.setPasswordHash(encodedPassword);
            credentialsRepository.save(userCredentials);
            User user = new User(login);
            userRepository.save(user);
        }
    }

    public User getUserByIdentifier(String id) {
        return userRepository.findOne(id);
    }
}
