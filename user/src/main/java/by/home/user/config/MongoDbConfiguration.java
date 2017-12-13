package by.home.user.config;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

/**
 * Created by alek on 13.12.17.
 */
@Configuration
@EnableMongoRepositories(basePackages = "by.home.user.repository")
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
