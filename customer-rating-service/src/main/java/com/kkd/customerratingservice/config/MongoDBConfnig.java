package com.kkd.customerratingservice.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.kkd.customerratingservice.document.Customers;
import com.kkd.customerratingservice.repository.CustomerRating;

@Configuration
@EnableMongoRepositories(basePackageClasses = CustomerRating.class)
public class MongoDBConfnig {
}
