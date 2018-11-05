package org.test.bookpub;



import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import org.test.bookpub.entity.Author;
import org.test.bookpub.entity.Book;
import org.test.bookpub.repository.AuthorRepository;
import org.test.bookpub.repository.BookRepository;


@Component
public class BookLoader implements ApplicationListener<ContextRefreshedEvent> {

	private BookRepository bookRepository;
	private AuthorRepository authorRepository;
	private Log log = LogFactory.getLog(getClass());
	
	/*@Autowired
	public void setBookRepository(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}
	
	@Autowired
	public void setAuthorRepository(AuthorRepository authorRepository) {
		this.authorRepository = authorRepository;
	}
	*/
	@Override
	public void onApplicationEvent(ContextRefreshedEvent arg0) {
/*		Author author = new Author();
		author.setFirstName("Umberto");
		author.setLastName("Eco");
		Book book = new Book();
		List<Book> books = new ArrayList<>();
		book.setTitle("Numele trandafirului");
		book.setDescription("test description");
		book.setAuthor(author);
		books.add(book);
		authorRepository.save(author);
		bookRepository.save(book);*/
		
		
		/*Book book2 = new Book();
		book2.setTitle("Magicianul");
		book2.setDescription("an interesting journey");
		bookRepository.save(book2);*/
		log.info("Books saved");
	}

}
