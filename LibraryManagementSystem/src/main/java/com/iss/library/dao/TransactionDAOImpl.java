package com.iss.library.dao;

import com.iss.library.models.Transaction;
import com.iss.library.util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class TransactionDAOImpl implements TransactionDao {


    @Override
    public void issueBook(Transaction t) {
        try {
            Connection con = DBConnection.getConnection();

            String sql = "INSERT INTO transactions(book_id, user_id, issue_date) VALUES (?, ?, CURDATE())";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, t.getBookId());
            ps.setInt(2, t.getUserId());

            ps.executeUpdate();
            ps.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void returnBook(int bookId, int userId) {
        try {
            Connection con = DBConnection.getConnection();

            String sql = "UPDATE transactions SET return_date=CURDATE() WHERE book_id=? AND user_id=? AND return_date IS NULL";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, bookId);
            ps.setInt(2, userId);

            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Transaction getActiveTransaction(int bookId) {
        try {
            Connection con = DBConnection.getConnection();

            String sql = "SELECT * FROM transactions WHERE book_id=? AND return_date IS NULL";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, bookId);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return new Transaction(
                        rs.getInt("book_id"),
                        rs.getInt("user_id")
                );
            }
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Transaction> getAllTransactions() {
        List<Transaction> list = new ArrayList<>();

        try {
            Connection con = DBConnection.getConnection();

            ResultSet rs = con.createStatement().executeQuery("SELECT * FROM transactions");

            while (rs.next()) {
                Transaction t = new Transaction(
                        rs.getInt("book_id"),
                        rs.getInt("user_id")
                );
                t.setReturnDate(
                        rs.getDate("return_date") != null ? rs.getDate("return_date").toLocalDate() : null
                );
                list.add(t);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }
    public List<Transaction> getUserTransactions(int userId) {
        List<Transaction> list = new ArrayList<>();

        try {
            Connection con = DBConnection.getConnection();

            String sql = "SELECT * FROM transactions WHERE user_id=? AND return_date IS NULL";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, userId);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Transaction t = new Transaction(
                        rs.getInt("book_id"),
                        rs.getInt("user_id")
                );

                t.setReturnDate(null);
                list.add(t);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }
}
