package by.home.user.repository;

import by.home.user.model.Token;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by alek on 15.12.17.
 */
public interface TokenRepository extends MongoRepository<Token, String> {
}
