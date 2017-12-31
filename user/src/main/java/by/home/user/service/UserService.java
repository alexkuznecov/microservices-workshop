package by.home.user.service;

import by.home.user.exceptions.LoginAlreadyExistException;
import by.home.user.exceptions.UnauthorizedUserException;
import by.home.user.exceptions.UserNotFoundException;
import by.home.user.model.User;

/**
 * Created by alek on 31.12.17.
 */
public interface UserService {

    String login(String login, String password) throws UnauthorizedUserException, UserNotFoundException;

    void registerUser(String login, String password) throws LoginAlreadyExistException;

    User getUserByIdentifier(String id);

}
