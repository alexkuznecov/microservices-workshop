package by.home.config;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

/**
 * @author alek
 * @since 0.0.1
 */
@Configuration
public class MongoDbConfiguration extends AbstractMongoConfiguration {

    @Override
    protected String getDatabaseName() {
        return "testdb";
    }

    @Override
    public Mongo mongo() throws Exception {
        return new MongoClient("127.0.0.1", 27017);
    }
}
