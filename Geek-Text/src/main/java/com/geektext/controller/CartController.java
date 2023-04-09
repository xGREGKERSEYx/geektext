//Controller recieve HTTP requests and return HTTP responses
// https://www.baeldung.com/spring-response-entity
// https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/http/ResponseEntity.html
//https://www.twilio.com/blog/create-rest-apis-java-spring-boot

package com.geektext.controller;

import com.geektext.model.Books;
import com.geektext.model.ShoppingCart;
import com.geektext.model.User;
import com.geektext.service.CartService;
import jakarta.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController //Spring Annotation
@RequestMapping(path="/")//Spring Annotation, URI's (endpoints) start with shoppingcart
public class CartController {
    
    @Autowired //Spring annotation, cartService calls CartService which implements getCartData
    private CartService cartService;
    
    private User user;
    

    public CartController(CartService cartService) {
        this.cartService = cartService;
    }//WIHTOUT THE CONSTUCTOR, RESULTED IN CIRCULAR INJECTION
    
    @GetMapping("/shoppingcart")
    public List<ShoppingCart> getCarts(){
        return cartService.getAllCartData();    
    }//Retrieves all carts
    
    
    @GetMapping("/shoppingcart/subtotal")
    public ResponseEntity<Long> getSubTotal(@RequestBody Map<String, Object> request) {//RequestBody allows us to use Postman
        Long user_id = Long.valueOf(request.get("user_id").toString());
        //Value is an Int in the DB, so we are parsing it into a Long value (foreign key)
        Long subtotal = cartService.getSubtotal(user_id);
        return ResponseEntity.ok().body(subtotal);
}//Response Entity allows us to view the reponse via web page

    
    @PostMapping("/shoppingcart/user/add")
    public ResponseEntity addBookToCart(@RequestBody Map<String, Object> request){
         Long user_id = Long.valueOf(request.get("user_id").toString());
         Long book_id = Long.valueOf(request.get("book_id").toString());
         cartService.addBookToCart(user_id, book_id);
        
        return ResponseEntity.ok("ADDED");
    
    }//Adds a book to specified user's cart
    
    
    @GetMapping("/shoppingcart/user")
    public ResponseEntity<List<Books>> getUserCart(@RequestBody Map<String, Object> request){
        Long user_id = Long.valueOf(request.get("user_id").toString());
        return ResponseEntity.ok(cartService.getCartData(user_id));
        
    }//retrieves the specified user's cart
    
    @DeleteMapping("/shoppingcart/user/remove")
    public ResponseEntity removeBookFromCart(@RequestBody Map<String, Object> request){
        Long user_id = Long.valueOf(request.get("user_id").toString());
        Long book_id = Long.valueOf(request.get("book_id").toString());
        cartService.removeBookFromCart(book_id, user_id);
        
         return ResponseEntity.ok("REMOVED"); 
    }
    
//    public Long getUserId(HttpServletRequest request){
//        Long user_id = null;
//        Scanner scnr = new Scanner(System.in);
//        System.out.println("Please enter your user id: ");
//        user_id = scnr.nextLong();
//        
//        return user_id;
//    }//With a UI we could send a request for now this is entered using the command prompt
//    
//    public Long getBookId(HttpServletRequest request){
//        Long book_id = null;
//        Scanner scnr = new Scanner(System.in);
//        System.out.println("Please enter a book id: ");
//        book_id = scnr.nextLong();
//        
//        return book_id;
//    }//With a UI we could send a request for now this is entered using the command prompt
    
//    public int getBookQuantity(){
//        int book_quantity = 0;
//        Scanner scnr = new Scanner(System.in);
//        System.out.println("Please enter the quantity you would like to add to your cart: ");
//        book_quantity = scnr.nextInt();
//        
//        return book_quantity;
//    }//With a UI we could send a request for now this is entered using the command prompt
//  
}