package com.bookStore.bookStore.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.bookStore.bookStore.entity.Book;
import com.bookStore.bookStore.entity.MyBookList;
import com.bookStore.bookStore.service.BookService;
import com.bookStore.bookStore.service.MyBookListService;



import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.ui.Model;


@Controller

public class BookController {
	
	@Autowired
	private BookService bookService;
	
	@Autowired
	private MyBookListService  myBookListService;
	
  @GetMapping("/")
	  public String home() {
		  return "home";
				  
	  }
  @GetMapping("/book_register")
  public String bookRegister() {
	  return "bookRegister";
  }
  @GetMapping("/available-books")
  public ModelAndView getAllBook() {
	  List<Book> list=bookService.getAllBook();
//	  ModelAndView m=new ModelAndView();
//	  m.setViewName("bookList");
//	  m.addObject("book",list);
	  return new ModelAndView("bookList","book",list);
  }     
  @PostMapping("/save")
  public String addBook(@ModelAttribute Book b) {
      bookService.save(b);
      
      return "redirect:/available-books";
  }
  @GetMapping("/my_books")
  public String getMyBooks(Model model) {
      List<MyBookList> list = myBookListService.getAllMyBooks();
      model.addAttribute("book", list);
      return "myBooks";  // This should match your Thymeleaf template name
  }
  
   @RequestMapping("/mylist/{id}")
   public String getMyList(@PathVariable("id") int id) {
	   Book b= bookService.getBookById(id);
	   MyBookList mb=new MyBookList(b.getId(),b.getName(),b.getAuthor(),b.getPrice());
	   myBookListService.saveMyBooks(mb);
       return "redirect:/my_books";
   }
   
   @RequestMapping("/editBook/{id}")
   public String editBook(@PathVariable("id") int id,Model model) {
	   Book b=bookService.getBookById(id);
	  
	   model.addAttribute("book",b);
       return  "bookEdit";
   }
   
   @RequestMapping("/deleteBook/{id}")
   public String deleteBook(@PathVariable("id") int id) {
	   bookService.deleteById(id);
       return "redirect:/available-books";
   }
   
   
  
  }

