package com.example.demomogodbreactive.configuration;

import com.mongodb.reactivestreams.client.MongoClient;
import com.mongodb.reactivestreams.client.MongoClients;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MongoConfiguration {

    @Value("${spring.data.mongodb.uri}")
    private String mongoUri;

    /*
     * Use the standard Mongo driver API to create a com.mongodb.client.MongoClient instance.
     */
    @Bean
    public MongoClient mongoClient() {
        return MongoClients.create(mongoUri);
    }
}
