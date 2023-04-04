package com.koios.server.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.koios.server.model.User;
import com.koios.server.repository.UserRepository;

@RestController
@RequestMapping("/users/{userId}/cart")
public class CartController {
  @Autowired
  private CartService cartService;

  @PostMapping
  public ResponseEntity<User> createCart(@PathVariable Long userId) {
    User user = cartService.createCart(userId);
    return ResponseEntity.ok(user);
  }

  @PostMapping("/items")
  public ResponseEntity<CartItem> addItem(@PathVariable Long userId, @RequestParam String bookName) {
    CartItem item = cartService.addItem(userId, bookName);
    return ResponseEntity.ok(item);
  }

  @GetMapping("/items")
  public ResponseEntity<List<CartItem>> getItems(@PathVariable Long userId) {
    List<CartItem> items = cartService.getItems(userId);
    return ResponseEntity.ok(items);
  }

  @DeleteMapping("/items/{itemId}")
  public ResponseEntity<Void> deleteItem(@PathVariable Long itemId) {
    cartService
