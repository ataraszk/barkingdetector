package ataraszkiewicz.config;

import ataraszkiewicz.repo.NoiseRepo;
import com.mongodb.Mongo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.authentication.UserCredentials;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

/**
 * @author ataraszkiewicz
 * @since 2015-08-31
 */
@Configuration
@EnableMongoRepositories(basePackageClasses = NoiseRepo.class)
public class MongoConfig {


    @Bean
    public MongoTemplate mongoTemplate() throws Exception {
        String host = "127.0.0.1";
        int port = 27017;
//        String username = System.getenv("OPENSHIFT_MONGODB_DB_USERNAME");
//        String password = System.getenv("OPENSHIFT_MONGODB_DB_PASSWORD");
        Mongo mongo = new Mongo(host, port);
//        UserCredentials userCredentials = new UserCredentials(username, password);
        String databaseName = "barkdetector";
        MongoDbFactory mongoDbFactory = new SimpleMongoDbFactory(mongo, databaseName);
        MongoTemplate mongoTemplate = new MongoTemplate(mongoDbFactory);
        return mongoTemplate;
    }

}
