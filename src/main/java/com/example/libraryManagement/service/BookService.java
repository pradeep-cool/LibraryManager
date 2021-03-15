package com.example.libraryManagement.service;

import java.util.List;

import com.example.libraryManagement.domain.Book;

@SuppressWarnings("hiding")
public interface BookService<Book> {

	List<Book> getAllBooks()throws Exception;
	
	List<Book> getBooksByName(String name)throws Exception;
	
	List<Book> getBooksByAuthor(String author)throws Exception;
	
	List<Book> selectBook(String name,String author)throws Exception;
	
	List<Book> saveBook(List<Book> Book)throws Exception;
	
	void updateReturnTime(int time,String name)throws Exception;
	
	void deleteBook(String name)throws Exception;
}
