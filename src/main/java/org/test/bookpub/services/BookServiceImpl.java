package org.test.bookpub.services;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.test.bookpub.entity.Book;
import org.test.bookpub.repository.BookRepository;

@Service
public class BookServiceImpl implements BookService{
	
	private BookRepository bookRepository;
	
	@Autowired
	public void setBookRepository(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}

	@Override
	public Iterable<Book> listAllBooks() {
		// TODO Auto-generated method stub
		return bookRepository.findAll();
	}

	@Override
	public Optional<Book> getBookById(Long id) {
		// TODO Auto-generated method stub
		return bookRepository.findById(id);
	}

	@Override
	public Book saveBook(Book book) {
		// TODO Auto-generated method stub
		return bookRepository.save(book);
	}

	@Override
	public void deleteBook(Long id) {
		bookRepository.deleteById(id);
		
	}

	@Override
	public Iterable<Book> findAllBooksByAuthorName(String lastName) {
		// TODO Auto-generated method stub
		
		return bookRepository.findAllBooksByAuthorName(lastName);
	}

	@Override
	public Book updateBook(Long id, Book newBook) {
	bookRepository.deleteById(id);
	bookRepository.save(newBook);
		return newBook;
	}

}
