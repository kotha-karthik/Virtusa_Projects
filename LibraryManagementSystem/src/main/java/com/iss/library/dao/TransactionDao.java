package com.iss.library.dao;

import com.iss.library.models.Transaction;

import java.util.List;

public interface TransactionDao {
    void issueBook(Transaction t);
    void returnBook(int bookId, int userId);
    Transaction getActiveTransaction(int bookId);
    List<Transaction> getAllTransactions();

    List<Transaction> getUserTransactions(int userId);
}
