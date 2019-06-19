package com.example.aon1.Bootstrap;

import java.util.Set;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.example.aon1.Author;
import com.example.aon1.Book;
import com.example.aon1.Publisher;
import com.example.aon1.repositories.AuthorRepository;
import com.example.aon1.repositories.BookRepository;
import com.example.aon1.repositories.PublisherRepository;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {
	
	private AuthorRepository authorRepository;
	private BookRepository bookRepository;
	private PublisherRepository publisherRepository;
	
	public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository,
			PublisherRepository publisherRepository) {
		super();
		this.authorRepository = authorRepository;
		this.bookRepository = bookRepository;
		this.publisherRepository = publisherRepository;
	}

	private void initData() {
		
		Publisher publisher = new Publisher("Goyal Publishes", "INDIA DELHI");

		Author eric = new Author("Eric", "Evans");
		Book book1 = new Book("Domain Driven Design", "1234", publisher);
		
		publisherRepository.save(publisher);
		
		eric.getBooks().add(book1);
		book1.getAuthors().add(eric);
		authorRepository.save(eric);
		bookRepository.save(book1);
		
		

				
		Author eric1 = new Author("Eric2", "Evans2");
		Book book2 = new Book("Domain Driven Design- 2", "1235", publisher);
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
