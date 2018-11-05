package org.test.bookpub.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.test.bookpub.entity.Author;
import org.test.bookpub.entity.Book;
import org.test.bookpub.services.AuthorService;

@RestController
public class AuthorController {

	private AuthorService authorService;
	
	@Autowired
	public void setAuthorService(AuthorService authorService) {
		this.authorService = authorService;
	}
	
	@RequestMapping(value = "/authors", method = RequestMethod.GET)
	   @ResponseBody
	   public Iterable<Author> findAll() {
	       return authorService.listAllAuthors();
	   }

	@RequestMapping(value = "/authors/{id}", method = RequestMethod.GET)
	   @ResponseBody
	   public Optional<Author> showBookById(@PathVariable("id") Long id) {
	       return authorService.getAuthorById(id);
	   }
	
	@RequestMapping(value = "authors/new", method = RequestMethod.POST)
	   @ResponseBody
	   public Author saveAuthor(@RequestBody Author author) {
		authorService.saveAuthor(author);
	       return author;
	   }
	
	@RequestMapping(value = "authors/delete/{id}", method = RequestMethod.DELETE)
	   @ResponseBody
	   public String deleteAuthor(@PathVariable("id") Long id) {
		try {
		authorService.deleteAuthor(id);
		} catch(Exception e) {
			return "Could not delete. We could not find author with id: " + id;
		}
		
	     return "Author with id: " + id + " was deleted.";
	   }
}
