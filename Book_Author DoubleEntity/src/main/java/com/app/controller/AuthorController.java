package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.entities.Author;
import com.app.service.AuthorService;

@RestController
@RequestMapping("/author")
public class AuthorController {
	@Autowired
	private AuthorService authService;
	
	@GetMapping("/details")
	public List<Author> listAuthor(){
		return authService.getDetails();
	}
	
	@PostMapping("/insert")
	public ResponseEntity<?> insert(@RequestBody Author auth){
		return new ResponseEntity<>(authService.addAuthor(auth), HttpStatus.ACCEPTED);
	}

}
