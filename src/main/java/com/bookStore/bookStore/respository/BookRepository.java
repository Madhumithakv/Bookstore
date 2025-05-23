package com.bookStore.bookStore.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bookStore.bookStore.entity.Book;
@Repository
public interface BookRepository extends JpaRepository<Book, Integer>{

}
