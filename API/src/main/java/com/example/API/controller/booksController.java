package com.example.API.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.API.model.books;
import com.example.API.service.booksService;

@RestController
public class booksController {
	
	@Autowired
	private booksService bkservice;
	
	@GetMapping("/books")
	public List<books> getBooks() {
		return this.bkservice.getBookData();
	}

}
