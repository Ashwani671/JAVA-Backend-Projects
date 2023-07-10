package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.ApiResponse;
import com.app.entities.Book;
import com.app.service.BookService;

@RestController
@RequestMapping("/books")
public class BookController {
	@Autowired
	private BookService bookService;
	
	@GetMapping("/details")
	
	public List<Book> getBooks(){
		return bookService.getAllBooks();
	}
	
	@PostMapping("/insert")
	public ResponseEntity<?> insertBook(@RequestBody Book b) {
		return new ResponseEntity<>(bookService.addBook(b), HttpStatus.ACCEPTED);
	}
	@PutMapping("/update")
	public Book updateBook(@RequestBody Book b) {
		return bookService.updatebook(b);
	}
	
	@DeleteMapping("/delete/{id}")
	public ApiResponse deleteBook(@PathVariable Long id) {
		return new ApiResponse(bookService.deleteBook(id));
	}

}
