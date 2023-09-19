package com.marketracker.demo.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@CrossOrigin("*")
public class Controller {
	@RequestMapping("/hello")
	public String hello() {
		return "Hello World!";
	}
	@GetMapping(value = "/search/{cod}")
	public String getInforPetra(@PathVariable("cod") String cod) {
		String uri = "https://brapi.dev/api/quote/"+cod+"?token=&range=6mo&interval=1d&fundamental=true&dividends=false";

		RestTemplate restTemplate = new RestTemplate();
		
		String result = restTemplate.getForObject(uri, String.class);
		return result;
	}
	
}
