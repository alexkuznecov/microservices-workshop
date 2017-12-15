package by.home.user.repository;

import by.home.user.model.Credentials;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by alek on 14.12.17.
 */
@Repository
public interface CredentialsRepository extends MongoRepository<Credentials, String> {

    List<Credentials> findByLoginAndPasswordHash(String login, String passwordHash);

    List<Credentials> findByLogin(String login);

}
