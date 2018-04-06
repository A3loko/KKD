package com.kkd.customerratingservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import brave.sampler.Sampler;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients("com.kkd.customerratingservice")
public class CustomerRatingServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerRatingServiceApplication.class, args);
	}
	
	@Bean
	public Sampler defaultSampler()
	{
		return Sampler.ALWAYS_SAMPLE;
	}
}
