package com.example.libraryManagement.controller;


import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.libraryManagement.domain.Book;
import com.example.libraryManagement.service.BookService;

/*This is a controller class for User 
 * who has ability to view Book information by name,author and can checkout book in DB*/
@RestController
@RequestMapping("/user")
public class User {
	
	@SuppressWarnings("rawtypes")
	private final BookService bookService;

	public User(BookService bookService) {
		this.bookService = bookService;
	}
	
	/*This method is used to get all book details that are present in DB*/
	@GetMapping("/getAllBooks")
	public Object getAllBooksAvailable() throws Exception{
		return bookService.getAllBooks();
	}
	
	/*This method is used to get book details based on title from DB*/
	@GetMapping("getBookByName")
	public Object getBookByName(@RequestParam(value = "name") String name) throws Exception{
		if(name.length() == 0 || name == null) {
			throw new Exception("Invalid book name requested");
		}
		else {
			return bookService.getBooksByName(name);
		}
	}
	
	/*This method is used to get book details based on author from DB*/
	@GetMapping("getBookByAuthor")
	public Object getBookByAuthor(@RequestParam(value = "author") String author) throws Exception{
		if(author.length() == 0 || author == null) {
			throw new Exception("Invalid book name requested");
		}
		else {
			return bookService.getBooksByAuthor(author);
		}
	}
	
	/*This method is used to get book details that are checked out by user in DB*/
	@GetMapping("selectBook")
	public List<Book> selectBook(@RequestParam(value = "name") String name,@RequestParam(value = "author") String author) throws Exception {
		if(name.length() == 0 || name == null) {
			throw new Exception("Invalid book name requested");
		}
		else {
			try {
				return bookService.selectBook(name,author);
				
			}catch(Exception e) {
				throw new Exception(e.getMessage());
			}
		}
	}
}
