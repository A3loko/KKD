package com.kkd.customerratingservice.proxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "mock-service", url = "http://localhost:9876")
public interface CustomerRatingMockProxy {
	
	@GetMapping("/cust")
	public String custId();
	
	@GetMapping("/farm")
	public String farmId();
	
	@GetMapping("/order")
	public String orderId();
	
	@GetMapping("/rating")
	public Float rating();
	
	@GetMapping("/review")
	public String review();

}
