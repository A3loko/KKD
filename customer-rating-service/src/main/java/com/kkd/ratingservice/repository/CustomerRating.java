package com.kkd.ratingservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.kkd.ratingservice.model.Rating;


//MongoDB repository
public interface CustomerRating extends MongoRepository<Rating, String>{
	
}
