//responsible for business logic to support controller

package com.geektext.service;

import com.geektext.model.Books;
import com.geektext.model.ShoppingCart;
import com.geektext.model.User;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public interface CartService{
    
  
    public List<Books> getCartData(Long user_id);
    
    public List<ShoppingCart> getAllCartData();
    
    public Long getSubtotal(Long user_id);
    
    public void addBookToCart(Long book_id, Long user_id);
    
    public void removeBookFromCart(Long book_id, Long user_id);
}
