package com.mycompany.SpringBootCrud.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mycompany.SpringBootCrud.bean.Book;

@Repository
public interface BookRepository extends JpaRepository<Book,String> { 

	List<Book> findByAuthorContainingIgnoreCase(String author);
}
