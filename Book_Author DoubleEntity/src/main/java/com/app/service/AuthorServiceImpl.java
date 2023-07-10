package com.app.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.entities.Author;
import com.app.repository.AuthorRepository;

@Service
@Transactional
public class AuthorServiceImpl implements AuthorService{

	@Autowired
	private AuthorRepository authRepo;
	@Override
	public List<Author> getDetails() {
		// TODO Auto-generated method stub
		return authRepo.findAll();
	}

	@Override
	public Author addAuthor(Author transauth) {
		// TODO Auto-generated method stub
		return authRepo.save(transauth);
	}

	@Override
	public String deleteAuthor(Long id) {
		// TODO Auto-generated method stub
		String msg="Can't be deleted";
		if(authRepo.existsById(id)) {
			authRepo.deleteById(id);
			msg= "deleted successfully";
		}
		return msg;
	}

	@Override
	public Author updateAuthor(Author detachauth) {
		// TODO Auto-generated method stub
		return authRepo.save(detachauth);
	}

}
