package org.test.bookpub.controllers;


import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.test.bookpub.entity.Book;
import org.test.bookpub.services.BookService;



@RestController
public class BookController {

	private BookService bookService;
	
	@Autowired
    public void setBookService(BookService bookService) {
        this.bookService = bookService;
    }

   /* @RequestMapping(value = "/books", method = RequestMethod.GET)
    public String list(Model model){
        model.addAttribute("books", bookService.listAllBooks());
        return "books";
    }*/
	@RequestMapping(value = "/books", method = RequestMethod.GET)
	   @ResponseBody
	   public Iterable<Book> findAll() {
	       return bookService.listAllBooks();
	   }

	@RequestMapping(value = "/book/{id}", method = RequestMethod.GET)
	   @ResponseBody
	   public Optional<Book> showBookById(@PathVariable("id") Long id) {
	       return bookService.getBookById(id);
	   }
	
	@RequestMapping(value = "books/new", method = RequestMethod.POST)
	   @ResponseBody
	   public Book saveBook(@RequestBody Book book) {
		bookService.saveBook(book);
	       return book;
	   }
	
	@RequestMapping(value = "books/delete/{id}", method = RequestMethod.DELETE)
	   @ResponseBody
	   public String deleteBook(@PathVariable("id") Long id) {
		try {
		bookService.deleteBook(id);
		} catch(Exception e) {
			return "Could not delete. We could not find book with id: " + id;
		}
		
	     return "Book with id: " + id + " was deleted.";
	   }
	@RequestMapping(value = "books/{lastName}", method = RequestMethod.GET)
	   @ResponseBody
	   public Iterable<Book> findBookByAuthorName(@PathVariable("lastName") String lastName) {
		return bookService.findAllBooksByAuthorName(lastName);
	   }
	
	@RequestMapping(value = "books/update/{id}", method = RequestMethod.PUT)
	   @ResponseBody
	   public Book updateBook(@PathVariable("id") Long id, @RequestBody Book newBook) {
		return bookService.updateBook(id, newBook);
	
	   }
}
