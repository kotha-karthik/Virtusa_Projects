package com.iss.library.services;

import com.iss.library.dao.BookDAOImpl;
import com.iss.library.dao.BookDao;
import com.iss.library.exceptions.BookNotFoundException;
import com.iss.library.models.Book;
import com.iss.library.models.User;
import java.util.List;
public class BookService {

    private BookDao bookDAO = new BookDAOImpl();
    public void addBook(Book book, User user) {
        checkAdmin(user);
        bookDAO.addBook(book);
    }

    public void updateBook(Book book, User user) {
        checkAdmin(user);
        bookDAO.updateBook(book);
    }

    public void deleteBook(int id, User user) {
        checkAdmin(user);
        bookDAO.deleteBook(id);
    }

    public List<Book> getAllBooks() {
        return bookDAO.getAllBooks();
    }

    public Book getBookById(int id) {
        Book book = bookDAO.getBookById(id);

        if (book == null) {
            throw new BookNotFoundException("Book not found!");
        }

        return book;
    }

    public void updateQuantity(int bookId, int qty) {
        bookDAO.updateQuantity(bookId, qty);
    }

    private void checkAdmin(User user) {
        if (!user.getRole().equals("ADMIN")) {
            throw new RuntimeException("Access Denied! Admin only.");
        }
    }
}
