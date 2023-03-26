package com.geektext.service;

import com.geektext.database.DatabaseUtility;
import com.geektext.model.BookDetails;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class BookDetailServiceImpl implements BookDetailServices{
    
    @Autowired
    static List<BookDetails> bookDetails = new ArrayList();//List to store data from database
    
    Connection connection;
    
    public BookDetailServiceImpl() throws SQLException{
        connection = DatabaseUtility.getConnection();
    }

    @Override
    public List<BookDetails> getBookData() {
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM book_details");
            ResultSet rs = statement.executeQuery();//Retreived data comes in the form of a table
            
            while(rs.next()){
                BookDetails newDetails = new BookDetails(rs.getString(1),rs.getString(2), 
                        rs.getInt(3), rs.getInt(4),
                        rs.getFloat(5), rs.getFloat(6), 
                        rs.getString(7) );                
//                newDetails.setDescription(rs.getString(1));
//                newDetails.setYear_Published(rs.getString(2));
//                newDetails.setCopies_Sold(rs.getString(3));
//                newDetails.setRating(rs.getString(4));
//                newDetails.setPrice(rs.getString(5));
//                newDetails.setDiscount_Price(rs.getString(6));
//                newDetails.setComments(rs.getString(7));
                
                
            }//Because it comes in a table we have to iterate through
            
        } catch (SQLException ex) {
            Logger.getLogger(BookDetailServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
}
