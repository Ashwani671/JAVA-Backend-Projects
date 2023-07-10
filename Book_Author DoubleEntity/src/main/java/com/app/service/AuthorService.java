package com.app.service;

import java.util.List;

import com.app.entities.Author;

public interface AuthorService {
	
	List<Author> getDetails();
	Author addAuthor(Author transauth);
	String deleteAuthor(Long id);
	Author updateAuthor(Author detachauth);
	
	
	
	

}
