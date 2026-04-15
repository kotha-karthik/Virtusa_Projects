package com.iss.library.dao;
import com.iss.library.models.Book;
import com.iss.library.util.DBConnection;
import java.sql.*;
import java.util.*;

public class BookDAOImpl implements BookDao {

    @Override
    public void addBook(Book book) {
        try {
            Connection con = DBConnection.getConnection();
            String sql = "INSERT INTO books(title, author, publisher, quantity, available_qty) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, book.getTitle());
            ps.setString(2, book.getAuthor());
            ps.setString(3, book.getPublisher());
            ps.setInt(4, book.getQuantity());
            ps.setInt(5, book.getAvailableQty());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Book> getAllBooks() {
        List<Book> list = new ArrayList<>();
        try {
            Connection con = DBConnection.getConnection();
            ResultSet rs = con.createStatement().executeQuery("SELECT * FROM books");
            while (rs.next()) {
                Book b = new Book(
                        rs.getInt("id"),
                        rs.getString("title"),
                        rs.getString("author"),
                        rs.getString("publisher"),
                        rs.getInt("quantity"),
                        rs.getInt("available_qty")
                );
                list.add(b);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public void updateBook(Book book) {
        try {
            Connection con = DBConnection.getConnection();

            String sql = "UPDATE books SET title=?, author=?, publisher=?, quantity=? WHERE id=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, book.getTitle());
            ps.setString(2, book.getAuthor());
            ps.setString(3, book.getPublisher());
            ps.setInt(4, book.getQuantity());
            ps.setInt(5, book.getId());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Override
    public void deleteBook(int id) {
        try {
            Connection con = DBConnection.getConnection();
            String sql = "DELETE FROM books WHERE id=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Override
    public Book getBookById(int id) {
        try {
            Connection con = DBConnection.getConnection();
            String sql = "SELECT * FROM books WHERE id=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Book(
                        rs.getInt("id"),
                        rs.getString("title"),
                        rs.getString("author"),
                        rs.getString("publisher"),
                        rs.getInt("quantity"),
                        rs.getInt("available_qty")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    @Override
    public void updateQuantity(int bookId, int availableQty) {
        try {
            Connection con = DBConnection.getConnection();
            String sql = "UPDATE books SET available_qty=? WHERE id=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, availableQty);
            ps.setInt(2, bookId);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
