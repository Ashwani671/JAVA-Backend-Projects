package com.app.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;


public class HomePageController {
	public HomePageController() {
		// TODO Auto-generated constructor stub
		System.out.println("in ctor of HomePage");
	}
	
	@GetMapping
	
	public List<Integer> listNumbers(){
		return Arrays.asList(10,20,30,40,50,60,70,80,90,100);
	}

}
