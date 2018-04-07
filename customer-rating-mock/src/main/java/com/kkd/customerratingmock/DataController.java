package com.kkd.customerratingmock;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DataController {
	
	@GetMapping("/cust")
	public String custId() {
		return "YOOOO";
	}
	
	@GetMapping("/farm")
	public String farmId() {
		return "KKKKKK";
	}
	
	@GetMapping("/order")
	public String orderId() {
		return "WERTTd";
	}
	
	@GetMapping("/rating")
	public Float rating() {
		return 156f;
	}
	
	@GetMapping("/review")
	public String review() {
		return "Awesome";
	}

}
