package com.kkd.ratingservice.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.kkd.ratingservice.model.Rating;
import com.kkd.ratingservice.repository.CustomerRating;
import com.kkd.ratingservice.repository.FarmerRating;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;


@RestController
public class RatingController {
	
	
@Autowired
CustomerRating customerRating;

@Autowired
FarmerRating farmerRating;

//Get Mapping to get data of all farmers
@GetMapping("/rating/farmer")
public List<Rating> getAllFarmerRatings() {
	return farmerRating.findAll();
}

//Post mapping to add new farmer's rating
@PostMapping("/rating/farmer")
void addFarmerRating(@RequestBody Rating rating) {
	farmerRating.insert(rating);
}

//Get Mapping to retrieve data of a particular FarmerID
@GetMapping("/rating/farmer/{id}")
public List<Rating> getFarmerById(@PathVariable String id)
{
	List<Rating> idList=new ArrayList<Rating>();
	String dbId;
	Rating dbRating;
	List<Rating> ratingList = (List<Rating>) farmerRating.findAll();
	Iterator i = ratingList.iterator();
	while(i.hasNext())
	{
		dbRating=(Rating) i.next();
		dbId=dbRating.getKkdFarmId();
		if(dbId.equals(id)) {
			idList.add(dbRating);
		}
	}
	return idList;
}

//Customer Area starts here

//Get Mapping to get data of Customers
@GetMapping("/rating/customer")
public List<Rating> getAllCustomerRatings(){
	return customerRating.findAll();
}

//Post Mapping to add new Rating
@PostMapping("/rating/customer")
public void addCustomerRating(@RequestBody Rating rating) {
	customerRating.insert(rating);
}

//Get Mapping to retrieve data of particular CustomerId
@GetMapping("/rating/customer/{id}")
public List<Rating> getCustomerById(@PathVariable String id)
{
	List<Rating> idList=new ArrayList<Rating>();
	String dbId;
	Rating dbRating;
	List<Rating> ratingList = (List<Rating>) customerRating.findAll();
	Iterator i = ratingList.iterator();
	while(i.hasNext())
	{
		dbRating=(Rating) i.next();
		dbId=dbRating.getKkdCustId();
		if(dbId.equals(id)) {
			idList.add(dbRating);
		}
	}
	return idList;
}

	
}
