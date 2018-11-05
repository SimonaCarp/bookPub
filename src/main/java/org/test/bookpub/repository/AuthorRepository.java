package org.test.bookpub.repository;

import org.springframework.data.repository.CrudRepository;
import org.test.bookpub.entity.Author;

public interface AuthorRepository extends CrudRepository<Author, Long>{

}
