package com.bookStore.bookStore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookStore.bookStore.entity.MyBookList;
import com.bookStore.bookStore.respository.MyBookRepository;

@Service
public class MyBookListService {

	@Autowired
	private MyBookRepository bookRepository;
	
	public void saveMyBooks(MyBookList book) {
	bookRepository.save(book);
}
	public List<MyBookList> getAllMyBooks(){
		 return bookRepository.findAll();
	}
	
	public void deleteById(int id) {
		bookRepository.deleteById(id);
	}
	
}
