package com.example.API.service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.API.model.books;

@Qualifier("books")
@Repository
public interface booksService extends JpaRepository<books, Integer>{
	

}
