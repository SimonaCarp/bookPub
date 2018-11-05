package org.test.bookpub.services;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.test.bookpub.entity.Book;

public interface BookService {
	 Iterable<Book> listAllBooks();

	 Optional<Book> getBookById(Long id);

	    Book saveBook(Book book);

	    void deleteBook(Long id);
	  Iterable<Book> findAllBooksByAuthorName(String lastName);
	  
	  Book updateBook(Long id,Book newBook);
}
