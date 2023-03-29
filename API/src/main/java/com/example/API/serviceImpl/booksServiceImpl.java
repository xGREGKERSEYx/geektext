package com.example.API.serviceImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.API.DBUtil.DBUtil;
import com.example.API.model.books;
import com.example.API.service.booksService;

@Service
public class booksServiceImpl implements booksService {
	
	@Autowired
	static List<books> booksList = new ArrayList();
	
	Connection connection;
	
	public booksServiceImpl() throws SQLException {
		connection = DBUtil.getConnection();
	}
	
	@Override
	public List<books> getBookData() {
		
		try {
			PreparedStatement stmt = connection.prepareStatement("SELECT * FROM books");
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				books bk = new books();
				
				bk.setTitle(rs.getString(1));
				bk.setAuthor(rs.getString(2));
				bk.setGenre(rs.getString(3));
				bk.setSub_genre(rs.getString(4));
				bk.setPublisher(rs.getString(5));
				bk.setISBN(rs.getString(6));
				bk.setBook_id(rs.getInt(7));
				
				booksList.add(bk);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return booksList;
	}

	
	
}
