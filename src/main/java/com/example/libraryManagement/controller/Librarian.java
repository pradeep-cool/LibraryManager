package com.example.libraryManagement.controller;

import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.libraryManagement.domain.Book;
import com.example.libraryManagement.service.BookService;

/*This is a controller class for librarian 
 * who has ability to create,delete and update Book information in DB*/
@RestController
@RequestMapping("/librarian")
public class Librarian {
	
	private final BookService bookService;

	public Librarian(BookService bookService) {
		this.bookService = bookService;
	}
	
	/*This method is used to add book details in DB*/
	@SuppressWarnings("unchecked")
	@PostMapping("/addBook")
	public ResponseEntity<Object> addBook(@RequestBody List<Book> BookDTO) throws Exception{
		if (BookDTO == null ) {
			throw new Exception("invalid input");
		}else {
			BookDTO = bookService.saveBook(BookDTO);
			return ResponseEntity.created(new URI("/librarian/addBook/")).body(BookDTO);
		}
	}
	
	/*This method is used to update book return time details based on how much time and name of the book in DB*/
	@PutMapping("/updateReturn")
	public ResponseEntity<Object> updateReturnTime(@RequestParam(value = "time") int time,@RequestParam(value = "name") String name) throws Exception {
		if (time == 0 || name.length() ==0) {
			throw new Exception("invalid input");
		}else if(bookService.getBooksByName(name).size() != 0){
			bookService.updateReturnTime(time, name);
			return ResponseEntity.ok().body("Resource updated successfully");
		}else {
			return ResponseEntity.ok().body("Resource updation failed");
		}
	}
	
	/*This method is used to delete book details in DB*/
	@DeleteMapping("/deleteBook")
	public ResponseEntity<Object> deleteBook(@RequestParam(value = "name") String name) throws Exception {
		if (bookService.getBooksByName(name).size() ==0 &&  name.length() == 0 ) {
			throw new Exception("invalid input");
		}else if(bookService.getBooksByName(name).size() != 0){
			bookService.deleteBook(name);
			return ResponseEntity.ok().body("Resource deleted successfully");
		}else {
			return ResponseEntity.ok().body("Resource deletion failed");
		}
	}

}
