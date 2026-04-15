package com.iss.library.services;

import com.iss.library.dao.TransactionDAOImpl;
import com.iss.library.dao.TransactionDao;
import com.iss.library.models.Transaction;

import java.util.List;


public class TransactionService {
    private TransactionDao transactionDAO = new TransactionDAOImpl();

    public void issueBook(int bookId, int userId) {
        Transaction t = new Transaction(bookId, userId);
        transactionDAO.issueBook(t);
    }
    public void returnBook(int bookId, int userId) {

        transactionDAO.returnBook(bookId, userId);
    }
    public Transaction getActiveTransaction(int bookId) {
        return transactionDAO.getActiveTransaction(bookId);
    }
    public List<Transaction> getUserTransactions(int userId) {
        return transactionDAO.getUserTransactions(userId);
    }
    public List<Transaction> getAllTransactions() {
        return transactionDAO.getAllTransactions();
    }
}
