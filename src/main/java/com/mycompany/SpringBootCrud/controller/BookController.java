package com.mycompany.SpringBootCrud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.mycompany.SpringBootCrud.bean.Book;
import com.mycompany.SpringBootCrud.service.BookService;

@RestController
public class BookController {
	
	@Autowired
	private BookService bookService;
	
	@GetMapping("/insert_book")
	public ModelAndView showInsertPage() {
		return new ModelAndView("insert_book");
	}
	
	@GetMapping("/update_book")
	public ModelAndView showUpdatePage() {
		return new ModelAndView("update_book");
	}
	
	@GetMapping("/delete_book")
	public ModelAndView showDeletePage() {
		return new ModelAndView("delete_book");
	}
	

	@RequestMapping("/books")
	public List<Book> getAllBooks()
	{
		return bookService.getAllBooks();
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/books/id/{id}")
	public Book getBookById(@PathVariable String id) {
	    return bookService.getBookById(id);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/books/author/{author}")
    public List<Book> getBooksByAuthor(@PathVariable String author) {
        return bookService.getBooksByAuthor(author);
    }
	

	@RequestMapping(method = RequestMethod.POST, value="/books")
	public void addBook(@RequestBody Book book)
	{
		bookService.addBook(book);
	}
	
	@RequestMapping(method = RequestMethod.PUT, value="/books/{id}")
	public void updateBook(@PathVariable String id, @RequestBody Book book)
	{
		bookService.updateBook(id,book);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value="/books/{id}")
	public void deleteBook(@PathVariable String id)
	{
		bookService.deleteBook(id);
	}
}
