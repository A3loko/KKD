package com.kkd.customerratingservice.controller;

import java.util.Iterator;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kkd.customerratingservice.document.Customers;
import com.kkd.customerratingservice.proxy.CustomerRatingMockProxy;
import com.kkd.customerratingservice.repository.CustomerRating;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController()
@RequestMapping("/customer/rating")
public class CustomerController {
	
	@Autowired
	CustomerRatingMockProxy proxy;
	
	@Autowired
	CustomerRating customerRating;
	
	
	//Get all the reviews
	@GetMapping("/all")
	public List<Customers> getAllRatings() {
		return customerRating.findAll();
	}
	
	//Adding a review
	@HystrixCommand(fallbackMethod="ifAddFarmerRatingFails")
	@PostMapping("/add")
	String addFarmerRating(@RequestBody Customers customer) {
		customerRating.insert(customer);
		return "Success";
	}
	
	public String ifAddFarmerRatingFails(@RequestBody Customers customer) {
		return "Insertion failed";
	}
	
	
	//Mocking the data from other service
	@PostMapping("/mock")
	@HystrixCommand(fallbackMethod="ifAddFarmerMockFails")
	String addFarmerMock() {
		String cust=proxy.custId();
		String farm=proxy.farmId();
		String order=proxy.orderId();
		Float rate=proxy.rating();
		String view=proxy.review();
		
		/*
		JSONObject json = new JSONObject();
		JSONArray array = new JSONArray();
		JSONObject item = new JSONObject();
		item.put("kkdCustId", cust);
		item.put("kkdFarmId", farm);
		item.put("orderId", order);
		item.put("rating", rate);
		item.put("review", view);
		
		array.put(item);
		
		Customers customer = (JSONObject)json;
		*/
		
		
		Customers customer =new Customers();
		customer.setKkdCustId(cust);
		customer.setKkdFarmId(farm);
		customer.setOrderId(order);
		customer.setRating(rate);
		customer.setReview(view);
		
		try {
		customerRating.insert(customer);
		}catch(Exception e){
			return "Exception: " + e;
		}
		return "success";
	}
	
	
	public String ifAddFarmerMockFails() {
		
		return "Failure";
		
	}
	//Get a specific review based on customer Id
	@GetMapping("/all/{kkdCustId}")
	public Customers getOne(@PathVariable String kkdCustId) {
		return customerRating.findById(kkdCustId).get();
	}
	
	//Getting the average rating
	@GetMapping("/avg")
	public float average() {
		List<Customers> list = customerRating.findAll();
		Iterator<Customers> i = list.iterator();
		int number=0;
		float average=0;
		Customers cust;
		while(i.hasNext()) {
			cust=i.next();
			average=average+cust.getRating();
			number++;
		}
		
		return average/number;
	}
	
}
