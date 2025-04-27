package com.bookStore.bookStore.service;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookStore.bookStore.entity.Book;
import com.bookStore.bookStore.respository.BookRepository;

@Service

public class BookService {
	@Autowired
	private BookRepository bookRepository;
	public void save(Book b) {
		bookRepository.save(b);
	}
	
   public List<Book> getAllBook(){
	   return bookRepository.findAll();
   }
   
   public Book getBookById(int id) {
	return bookRepository.findById(id).get();
}
   public void deleteById( int id) {
	   bookRepository.deleteById(id);
   }
}
