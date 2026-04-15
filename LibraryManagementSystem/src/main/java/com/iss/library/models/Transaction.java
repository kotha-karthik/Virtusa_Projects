package com.iss.library.models;

import java.time.LocalDate;

public class Transaction {
    private int bookId;
    private int userId;
    private LocalDate issueDate;
    private LocalDate returnDate;

    public Transaction(int bookId, int userId) {
        this.bookId = bookId;
        this.userId = userId;
        this.issueDate = LocalDate.now();
    }
    public int getBookId() { return bookId; }
    public int getUserId() { return userId; }
    public LocalDate getIssueDate() { return issueDate; }

    public LocalDate getReturnDate() { return returnDate; }
    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }
    public LocalDate getDueDate() {
        return issueDate.plusDays(7);
    }

    public long getFine() {
        if (returnDate == null) {
            LocalDate today = LocalDate.now();
            if (today.isAfter(getDueDate())) {
                return java.time.temporal.ChronoUnit.DAYS.between(getDueDate(), today) * 5;
            }
        } else {
            if (returnDate.isAfter(getDueDate())) {
                return java.time.temporal.ChronoUnit.DAYS.between(getDueDate(), returnDate) * 5;
            }
        }
        return 0;
    }
}
