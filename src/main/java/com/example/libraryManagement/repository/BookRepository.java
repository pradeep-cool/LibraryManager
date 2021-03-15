package com.example.libraryManagement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.libraryManagement.domain.Book;

public interface BookRepository extends JpaRepository<Book,Long> {
	
	@Query("Select b from Book as b where b.title=:name")
	public List<Book> findBookByName(@Param("name") String name);
	
	@Query("Select b from Book as b where b.author=:author")
	public List<Book> findBookByAuthor(@Param("author") String author);
	
	@Query("Select b.count from Book as b where b.title=:name and b.author=:author")
	public int bookCount(@Param("name") String name,@Param("author") String author);
	
	@Modifying
	@Query(value="update Book set checkout_flag=true, checkout_date=:date, count=:count where title=:name and author=:author",nativeQuery=true)
	public void bookCheckOut(@Param("name") String name, @Param("date") int date,@Param("count") int count,@Param("author") String author);
	
	@Modifying
	@Query(value="update Book set checkout_flag=true, checkout_date=:time where title=:name",nativeQuery=true)
	public void updateReturnTime(@Param("time") int time,@Param("name") String name);
	
	@Modifying
	//@Query("update Book b set b.count=0 where b.title=:name")
	@Query("delete from Book b where b.title=:name")
	public void deleteBook(@Param("name") String name);

//	@Modifying
//	@Query("update Book as b set b.count=:count where b.title=:name")
//	public void bookCountIncrement(@Param("name") String name,@Param("count") int count);
	
	@Query("Select b from Book as b where b.author=:author and b.title=:name")
	public List<Book> findBook(@Param("author") String author,@Param("name") String name);
}
	