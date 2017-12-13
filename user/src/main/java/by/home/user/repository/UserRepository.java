package by.home.user.repository;

import by.home.user.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by alek on 14.12.17.
 */
@Repository
public interface UserRepository extends MongoRepository<User, String> {
}
