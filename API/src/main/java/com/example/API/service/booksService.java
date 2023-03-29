package com.example.API.service;

import java.util.List;
import org.springframework.stereotype.Repository;
import com.example.API.model.books;

@Repository
public interface booksService {
	
	public List<books> getBookData();

}
