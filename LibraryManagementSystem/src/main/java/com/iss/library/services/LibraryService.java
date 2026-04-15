package com.iss.library.services;

import com.iss.library.dao.*;
import com.iss.library.exceptions.BookNotFoundException;
import com.iss.library.models.Book;

import com.iss.library.models.Transaction;
import com.iss.library.models.User;
import com.iss.library.util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class LibraryService {

    private UserService userService = new UserService();
    private BookService bookService = new BookService();
    private TransactionService transactionService = new TransactionService();
    public User login(String username, String password) {

        return userService.login(username, password);
    }

    public void registerStudent(User user) {

        userService.registerStudent(user);
    }
    public void addBook(Book book, User user) {

        bookService.addBook(book, user);
    }


    public void deleteBook(int id, User user) {
        bookService.deleteBook(id, user);
    }

    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }
    public void issueBook(int bookId, int userId) {

        Book book = bookService.getBookById(bookId);

        if (book.getAvailableQty() <= 0) {
            throw new BookNotFoundException("Book out of stock!");
        }

        book.issueBook();
        bookService.updateQuantity(bookId, book.getAvailableQty());

        transactionService.issueBook(bookId, userId);
    }
    public void returnBook(int bookId, int userId) {

        Book book = bookService.getBookById(bookId);
        book.returnBook();
        bookService.updateQuantity(bookId, book.getAvailableQty());
        transactionService.returnBook(bookId, userId);
    }

    public List<Transaction> getUserTransactions(int userId) {

        return transactionService.getUserTransactions(userId);
    }
    public Book getBookById(int id) {

        return bookService.getBookById(id);
    }
    public List<Transaction> getAllTransactions() {
        return transactionService.getAllTransactions();
    }

    public void updateBookAdmin(Book book, User user) {
        String sql = "UPDATE books SET title=?, author=?, publisher=?, quantity=? WHERE id=?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, book.getTitle());
            ps.setString(2, book.getAuthor());
            ps.setString(3, book.getPublisher());
            ps.setInt(4, book.getQuantity());
            ps.setInt(5, book.getId());

            ps.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Error updating book: " + e.getMessage());
        }
    }


}