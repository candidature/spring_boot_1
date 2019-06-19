package com.example.aon1.Bootstrap;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.example.aon1.Author;
import com.example.aon1.Book;
import com.example.aon1.repositories.AuthorRepository;
import com.example.aon1.repositories.BookRepository;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {
	
	private AuthorRepository authorRepository;
	private BookRepository bookRepository;
	
	
	public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository) {
		super();
		this.authorRepository = authorRepository;
		this.bookRepository = bookRepository;
	}

	private void initData() {
		Author eric = new Author("Eric", "Evans");
		Book book1 = new Book("Domain Driven Design", "1234", "Goyal pubs");
		eric.getBooks().add(book1);
		book1.getAuthors().add(eric);
		authorRepository.save(eric);
		bookRepository.save(book1);
		
		Author eric1 = new Author("Eric2", "Evans2");
		Book book2 = new Book("Domain Driven Design- 2", "1235", "Goyal pubs- 2");
		eric1.getBooks().add(book2);
		book2.getAuthors().add(eric1);
		
		authorRepository.save(eric1);
		bookRepository.save(book2);
		
		
	}

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		// TODO Auto-generated method stub
		initData();
	}

}
