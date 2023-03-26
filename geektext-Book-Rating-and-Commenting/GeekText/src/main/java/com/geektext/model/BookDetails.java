package com.geektext.model;

import com.fasterxml.jackson.annotation.JsonProperty;


public class BookDetails {
    private String description;
    private String year_published;
    private int copies_sold;
    private int rating;
    private float price;
    private float discount_price;
    private String comments;

    public BookDetails(@JsonProperty("description")String description, 
            @JsonProperty("year_published")String year_published, 
            @JsonProperty("copies_sold")int copies_sold, 
            @JsonProperty("rating")int rating, 
            @JsonProperty("price")float price, 
            @JsonProperty("discount_price")float discount_price, 
            @JsonProperty("comments")String comments) {
        
        this.description = description;
        this.year_published = year_published;
        this.copies_sold = copies_sold;
        this.rating = rating;
        this.price = price;
        this.discount_price = discount_price;
        this.comments = comments;
    }    

    public String getDescription() {
        return description;
    }

    public String getYear_Published() {
        return year_published;
    }

    public int getCopies_Sold() {
        return copies_sold;
    }

    public int getRating() {
        return rating;
    }

    public float getPrice() {
        return price;
    }

    public float getDiscount_Price() {
        return discount_price;
    }

    public String getComments() {
        return comments;
    }

    public void setDescription(String newDescription) {
        this.description = newDescription;
    }
    
    public void setYear_Published(String newYear_Published) {
        this.description = newYear_Published;
    }
    
    public void setCopies_Sold(String newCopies_Sold) {
        this.description = newCopies_Sold;
    }
    
    public void setRating(String newRating) {
        this.description = newRating;
    }
    
    public void setPrice(String newPrice) {
        this.description = newPrice;
    }
    
    public void setDiscount_Price(String newDiscount_Price) {
        this.description = newDiscount_Price;
    }
    
    public void setComments(String newComments) {
        this.description = newComments;
    }
    
}
