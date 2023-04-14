package com.example.API.controller;

import java.util.List;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.API.model.book_details;
import com.example.API.model.books;
import com.example.API.service.book_detailsService;
import com.example.API.service.booksService;

@RestController
@RequestMapping("/books")
public class BookController {
	
	@Autowired
	private booksService bkservice;
	
	@Autowired
	private book_detailsService bkdservice;
	
	@GetMapping("/top")
	public List<books> getTopSellers() {
		List<book_details> detailsList = bkdservice.findAll();
		List<books> bookList = bkservice.findAll();
		List<books> Top = new ArrayList<>();
		
		for (int i = 0; i < 10; i++) {
			int key = 0;
			for (int j = 1; j < detailsList.size(); j++) {
				if (detailsList.get(j).getCopies_sold() > detailsList.get(key).getCopies_sold()) {
					key = j;
				}
			}
			for (int j = 0; j < bookList.size(); j++) {
				if (bookList.get(j).getBook_id() == detailsList.get(key).getBook_id_fk()) {
					Top.add(bookList.get(j));
				}
			}
			detailsList.remove(key);
		}
		
		detailsList.clear();
		bookList.clear();
		
		return Top;
		
	}
	
	@GetMapping("/genre/{id}")
	public List<books> getGenre(@PathVariable String id) {
		List<books> bookList = bkservice.findAll();
		List<books> genrelist = new ArrayList<>();
		
		for (int i = 0; i < bookList.size(); i++) {
			if (bookList.get(i).getGenre().equalsIgnoreCase(id)) {
				genrelist.add(bookList.get(i));
			}
		}
		
		bookList.clear();
		
		return genrelist;
	}
	
	@GetMapping("/rating/{id}")
	public List<books> getRating(@PathVariable String id) {
		int desiredRating = Integer.parseInt(id);
		List<books> bookList = bkservice.findAll();
		List<book_details> detailsList = bkdservice.findAll();
		List<books> ratinglist = new ArrayList<>();
		
		for (int i = 0; i < detailsList.size(); i++){
			if (detailsList.get(i).getRating() >= desiredRating) {
				ratinglist.add(bookList.get(i));
			}
		}
		
		bookList.clear();
		detailsList.clear();
		
		return ratinglist;
	}
	
	@PatchMapping("/{publisher}/{percent}")
	public void discountByPublisher(@PathVariable("publisher") String pub, @PathVariable("percent") String perc) {
		String publisher = pub.replace('-', ' ');
		double discountPercent = Double.parseDouble(perc);
		discountPercent = discountPercent * 0.01;
		List<books> bookList = bkservice.findAll();
		List<book_details> detailsList = bkdservice.findAll();
		
		for (int i = 0; i < bookList.size(); i++) {
			if (bookList.get(i).getPublisher().equalsIgnoreCase(publisher)) {
				double price  = detailsList.get(i).getPrice();
				double newPrice = price - (price * discountPercent);
				detailsList.get(i).setDiscount_price(newPrice);
				bkdservice.save(detailsList.get(i));
			}
		}
		
		bookList.clear();
		detailsList.clear();
		
		return;
	}
	

}
