package com.kkd.customerratingmock;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DataController {
	
	@GetMapping("/cust")
	public String custId() {
		return "kkd987";
	}
	
	@GetMapping("/farm")
	public String farmId() {
		return "kkd654";
	}
	
	@GetMapping("/order")
	public String orderId() {
		return "ord123";
	}
	
	@GetMapping("/rating")
	public Float rating() {
		return 987.15f;
	}
	
	@GetMapping("/review")
	public String review() {
		return "Nice";
	}

}
