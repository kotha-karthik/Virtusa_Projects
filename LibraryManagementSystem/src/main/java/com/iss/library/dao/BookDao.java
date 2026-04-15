package com.iss.library.dao;

import com.iss.library.models.Book;

import java.util.List;

public interface BookDao {
    void addBook(Book book);
    void updateBook(Book book);
    void deleteBook(int id);
    Book getBookById(int id);
    List<Book> getAllBooks();
    void updateQuantity(int bookId, int availableQty);
}
