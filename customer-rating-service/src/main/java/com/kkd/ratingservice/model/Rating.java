package com.kkd.ratingservice.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

//All the fields that need to be int he database
@Document
public class Rating {
	
	@Id
	private String kkdCustId;
	private String kkdFarmId;
	private String orderId;
	private Float rating;
	private String review;
	
	public Rating() {
		super();
	}

	public Rating(String kkdCustId, String kkdFarmId, String orderId, Float rating, String review) {
		super();
		this.kkdCustId = kkdCustId;
		this.kkdFarmId = kkdFarmId;
		this.orderId = orderId;
		this.rating = rating;
		this.review = review;
	}

	public String getKkdCustId() {
		return kkdCustId;
	}

	public void setKkdCustId(String kkdCustId) {
		this.kkdCustId = kkdCustId;
	}

	public String getKkdFarmId() {
		return kkdFarmId;
	}

	public void setKkdFarmId(String kkdFarmId) {
		this.kkdFarmId = kkdFarmId;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public Float getRating() {
		return rating;
	}

	public void setRating(Float rating) {
		this.rating = rating;
	}

	public String getReview() {
		return review;
	}

	public void setReview(String review) {
		this.review = review;
	}

	@Override
	public String toString() {
		return "Customers [kkdCustId=" + kkdCustId + ", kkdFarmId=" + kkdFarmId + ", orderId=" + orderId + ", rating="
				+ rating + ", review=" + review + "]";
	}
	
	
	
	

}
