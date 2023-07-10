package com.app.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.entities.Book;
import com.app.repository.BookRepository;
@Service
@Transactional
public class BookServiceImpl implements BookService {
@Autowired
private BookRepository bookRepo;
	@Override
	public List<Book> getAllBooks() {
		// TODO Auto-generated method stub
		return bookRepo.findAll();
	}

	@Override
	public Book addBook(Book transBook) {
		// TODO Auto-generated method stub
		return bookRepo.save(transBook);
	}

	@Override
	public Book updatebook(Book detachBook) {
		// TODO Auto-generated method stub
		return bookRepo.save(detachBook);
	}

	@Override
	public String deleteBook(Long id) {
		// TODO Auto-generated method stub
		String msg="Can't be deleted";
		if(bookRepo.existsById(id)) {
			bookRepo.deleteById(id);
			msg="Successgfully deleted";
		}
		return msg;
	}

}
