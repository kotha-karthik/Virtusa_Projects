package com.iss.library.models;

import com.iss.library.exceptions.BookNotFoundException;

public class Book {
    private int id;
    private String title;
    private String author;
    private String publisher;
    private boolean issued;
    private int quantity;
    private int availableQty;

    public Book(int id, String title, String author, String publisher, int quantity) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.quantity = quantity;
        this.availableQty = quantity;
    }
    public Book(int id, String title, String author, String publisher,int quantity,int availableQty) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.issued = false;
        this.quantity = quantity;
        this.availableQty = availableQty;
    }
    public int getId() {
        return id;
    }
    public String getTitle(){
        return title;
    }
    public String getAuthor(){
        return author;
    }
    public String getPublisher(){
        return publisher;
    }
    public boolean isIssued(){
        return issued;
    }
    public void setIssued(boolean issued){
        this.issued = issued;
    }
    public int getQuantity() { return quantity; }
    public int getAvailableQty() { return availableQty; }

    public void setQuantity(int quantity) { this.quantity = quantity; }
    public void setAvailableQty(int availableQty) { this.availableQty = availableQty; }
    public void issueBook() {
        if (availableQty <= 0) {
            throw new BookNotFoundException("No books available!");
        }
        availableQty--;
    }

    public void returnBook() {
        if (availableQty < quantity) {
            availableQty++;
        }
    }
}
