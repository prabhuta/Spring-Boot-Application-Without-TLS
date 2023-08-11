package com.mycompany.SpringBootCrud.service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycompany.SpringBootCrud.bean.Book;
import com.mycompany.SpringBootCrud.repository.BookRepository;

@Service
public class BookService {
	
	@Autowired
	public BookRepository bookRepo;

	public List<Book> getAllBooks()
	{
		List<Book> books = new ArrayList<>();
		bookRepo.findAll().forEach(books::add);
		return books;
	}

	public Book getBookById(String id) {
	    Optional<Book> optionalBook = bookRepo.findById(id);
	    if (optionalBook.isPresent()) {
	        return optionalBook.get();
	    } else {
	        throw new NoSuchElementException("Book not found with ID: " + id);
	    }
	}
	
	public List<Book> getBooksByAuthor(String author) {
        return bookRepo.findByAuthorContainingIgnoreCase(author);
    }
	
	public void addBook(Book book) {
		bookRepo.save(book);
	}

	public void updateBook(String id, Book updatedBook) {
	    Optional<Book> optionalBook = bookRepo.findById(id);
	    if (optionalBook.isPresent()) {
	        Book existingBook = optionalBook.get();
	        existingBook.setPrice(updatedBook.getPrice());
	        bookRepo.save(existingBook);
	    } else {
	        // Handle case when book with the given ID doesn't exist
	        throw new NoSuchElementException("Book with ID " + id + " not found");
	    }
	}

	public void deleteBook(String id) {
		bookRepo.deleteById(id);
	}
}
