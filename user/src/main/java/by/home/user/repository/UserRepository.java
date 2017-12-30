package by.home.user.repository;

import by.home.user.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * @author alek
 * @since 0.0.1
 */
@Repository
public interface UserRepository extends MongoRepository<User, String> {
}
