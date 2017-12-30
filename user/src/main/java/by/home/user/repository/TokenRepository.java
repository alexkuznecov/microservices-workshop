package by.home.user.repository;

import by.home.user.model.Token;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @author alek
 * @since 0.0.1
 */
public interface TokenRepository extends MongoRepository<Token, String> {
}
