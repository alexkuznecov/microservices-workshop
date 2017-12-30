package by.home.user.service;

import by.home.user.exceptions.LoginAlreadyExistException;
import by.home.user.exceptions.UnauthorizedUserException;
import by.home.user.exceptions.UserNotFoundException;
import by.home.user.model.Credentials;
import by.home.user.model.Token;
import by.home.user.model.User;
import by.home.user.repository.CredentialsRepository;
import by.home.user.repository.TokenRepository;
import by.home.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.authentication.UserCredentials;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

/**
 * Created by alek on 15.12.17.
 */
@Service
public class UserService {

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