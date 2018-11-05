package org.test.bookpub.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.test.bookpub.entity.Author;
import org.test.bookpub.repository.AuthorRepository;

@Service
public class AuthorServiceImpl implements AuthorService{


	private AuthorRepository authorRepository;
	
	@Autowired
	public void setAuthorRepository(AuthorRepository authorRepository) {
		this.authorRepository = authorRepository;
	}
	@Override
	public Iterable<Author> listAllAuthors() {
		// TODO Auto-generated method stub
		return authorRepository.findAll();
	}

	@Override
	public Optional<Author> getAuthorById(Long id) {
		// TODO Auto-generated method stub
		return authorRepository.findById(id);
	}

	@Override
	public Author saveAuthor(Author author) {
		// TODO Auto-generated method stub
		return authorRepository.save(author);
	}

	@Override
	public void deleteAuthor(Long id) {
		authorRepository.deleteById(id);
		
	}

}
