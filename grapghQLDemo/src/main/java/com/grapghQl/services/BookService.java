package com.grapghQl.services;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.grapghQl.entities.BookEntitiy;

public interface BookService {
	
	//create
	
	ResponseEntity create(BookEntitiy bookEntitiy);
	
	//update
	
	ResponseEntity update(BookEntitiy bookEntitiy);
	
	//getAll
	
	List getAll();
	
	//getOne
	
	BookEntitiy getBook(int id);
	

}
