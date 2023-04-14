package com.example.API.service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.API.model.book_details;

@Qualifier("book_details")
@Repository
public interface book_detailsService extends JpaRepository<book_details, Integer>{
	

}
