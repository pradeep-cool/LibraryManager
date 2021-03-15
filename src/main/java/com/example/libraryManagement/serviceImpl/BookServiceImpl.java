package com.example.libraryManagement.serviceImpl;

import java.util.List;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.libraryManagement.domain.Book;
import com.example.libraryManagement.repository.BookRepository;
import com.example.libraryManagement.service.BookService;

@Service
@Configuration
@Transactional
public class BookServiceImpl implements BookService<Book>{

	private BookRepository bookRepo;
	
	BookServiceImpl(BookRepository bookRepo){
		this.bookRepo = bookRepo;
	}
	@Override
	public List<Book> getBooksByName(String name) throws Exception {
		try {
			return bookRepo.findBookByName(name);
		}catch(Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	@Override
	public List<Book> getBooksByAuthor(String author) throws Exception{
		try {
			return bookRepo.findBookByAuthor(author);
		}catch(Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	
	@Override
	public List<Book> getAllBooks() throws Exception {
		try {
			return bookRepo.findAll();
		}catch(Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	@Override
	public List<Book> selectBook(String name,String author) throws Exception {
		try {
			int returnDate = 7;
			int bookCount = bookRepo.bookCount(name,author);
			bookCount = bookCount -1;
			bookRepo.bookCheckOut(name, returnDate,bookCount,author);
			return bookRepo.findBook(author, name);
		}catch(Exception e) {
			throw new Exception("Book not found");
		}
		
	}
	@Override
	public List<Book> saveBook(List<Book> Book) throws Exception {
		try {
			
			return bookRepo.saveAll(Book);
		}catch(Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	@Override
	public void updateReturnTime(int time,String name) throws Exception {
		try {
			bookRepo.updateReturnTime(time, name);
		}catch(Exception e) {
			throw new Exception(e.getMessage());
		}
		
	}
	@Override
	public void deleteBook(String name) throws Exception {
		try {
			bookRepo.deleteBook(name);
		}catch(Exception e) {
			throw new Exception(e.getMessage());
		}
		
	}
	
	
	

}
