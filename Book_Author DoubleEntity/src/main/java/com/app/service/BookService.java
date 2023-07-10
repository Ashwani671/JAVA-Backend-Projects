package com.app.service;

import java.util.List;

import com.app.entities.Book;

public interface BookService {
	List<Book> getAllBooks();
	Book addBook(Book transBook);
	Book updatebook(Book detachBook);
	String deleteBook (Long id);
	
	

}
