package com.example.aon1.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.aon1.repositories.BookRepository;

@Controller // registration of class in spring as spring bean.
public class RootController {
	
	private BookRepository bookRepository;
	
	public RootController(BookRepository bookRepository) {
		super();
		this.bookRepository = bookRepository;
	}

	@RequestMapping("/books")
	public String getBooks (Model model) {
		
		model.addAttribute("books" , bookRepository.findAll());
		
		return "books";
	
	}

}
