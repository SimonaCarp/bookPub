package org.test.bookpub.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.test.bookpub.entity.Book;



public interface BookRepository extends CrudRepository<Book, Long>{
	@Modifying
	@Query(value = "select * from book b, author a where  a.id = b.author_id and a.last_name= ?",  nativeQuery = true)
			Collection<Book> findAllBooksByAuthorName(String lastName);

	//Book updateBook(Long id, Book newBook);
}
