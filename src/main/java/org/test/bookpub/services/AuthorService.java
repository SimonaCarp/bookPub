package org.test.bookpub.services;

import java.util.Optional;

import org.test.bookpub.entity.Author;
import org.test.bookpub.entity.Book;

public interface AuthorService {
	 Iterable<Author> listAllAuthors();

	 Optional<Author> getAuthorById(Long id);

	    Author saveAuthor(Author author);

	    void deleteAuthor(Long id);
}
