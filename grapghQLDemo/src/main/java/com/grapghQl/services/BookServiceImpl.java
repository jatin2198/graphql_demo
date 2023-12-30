package com.grapghQl.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.grapghQl.entities.BookEntitiy;
import com.grapghQl.repos.BookRepo;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	BookRepo bookRepo;
	
	@Override
	public ResponseEntity create(BookEntitiy bookEntitiy) {
		// TODO Auto-generated method stub
		
		//bookRepo.save(bookEntitiy);
		return ResponseEntity.status(200).body(bookRepo.save(bookEntitiy));
	}

	@Override
	public ResponseEntity update(BookEntitiy bookEntitiy) {
		// TODO Auto-generated method stub
		
		Optional<BookEntitiy> book=bookRepo.findById(bookEntitiy.getId());
		if(book.isPresent()) {
		return ResponseEntity.accepted().body(bookRepo.save(bookEntitiy));}
		else {
			return ResponseEntity.badRequest().build();
		}
	}

	@Override
	public List<BookEntitiy> getAll() {
		// TODO Auto-generated method stub
		return bookRepo.findAll();
	}

	@Override
	public BookEntitiy getBook(int id) {
		// TODO Auto-generated method stub
		return bookRepo.findById(id).orElseThrow(()->new RuntimeException("No Book with this Id found"));
	}

}
