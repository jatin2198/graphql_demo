package com.grapghQl.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.grapghQl.entities.BookEntitiy;
import com.grapghQl.query_modles.BookInput;
import com.grapghQl.services.BookServiceImpl;

/*@RestController
@RequestMapping("/book_service")*/
@Controller
public class BookController {
	
	@Autowired
	BookServiceImpl bookservice;
	
	//*---comenting all rest controller Annnotation and we will implement GraphQl annotation
	
	//@PostMapping("/save_book")//@RequestBody--is also removed as we need to use Argument for Graphql
	@MutationMapping("createBook") //to create data with GraphQl
	public ResponseEntity createBookInfo(@Argument BookInput book) {
		
		BookEntitiy bookEntitiy=new BookEntitiy();
		bookEntitiy.setPrice(book.getPrice());
		bookEntitiy.setAuthor_name(book.getAuthor_name());
		bookEntitiy.setDescription(book.getDescription());
		bookEntitiy.setTitle(book.getTitle());
		bookEntitiy.setPages(book.getPages());
		return bookservice.create(bookEntitiy);
		
		
	}

	//@PostMapping("/update_book")
	public ResponseEntity updateBookInfo(@RequestBody BookEntitiy entitiy) {
		return bookservice.update(entitiy);
		
		
	}
	
	//@GetMapping("/get_all")
	@QueryMapping("allBookEntitiy")
	public List<BookEntitiy> getAllBooks() {
		return bookservice.getAll();
	}
	
	//@GetMapping("/get_byId/{id}") //PathVariavle also be removed 
	@QueryMapping("getBook") //QueryMapping to get Data
	public BookEntitiy getBookById(@Argument int id) {
		return bookservice.getBook(id);
	}
	

}
