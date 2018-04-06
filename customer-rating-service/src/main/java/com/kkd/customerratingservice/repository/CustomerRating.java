package com.kkd.customerratingservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.kkd.customerratingservice.document.Customers;


//MongoDB repository
public interface CustomerRating extends MongoRepository<Customers, String>{
	
}
