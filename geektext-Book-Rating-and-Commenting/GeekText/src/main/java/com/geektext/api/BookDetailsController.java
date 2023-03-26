package com.geektext.api;

import com.geektext.model.BookDetails;
import com.geektext.service.BookDetailServices;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookDetailsController {
    
    @Autowired
    private BookDetailServices bookServices;//Calls the object from BookDetailsServices
    
    @GetMapping("/bookdetails")
    public List<BookDetails> getBookData(){//Retruns a list of book detials
        return this.bookServices.getBookData();
    
    }
    
}
