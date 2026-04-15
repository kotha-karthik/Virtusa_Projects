package com.iss.library.frames;

import com.iss.library.models.Book;
import com.iss.library.models.Transaction;
import com.iss.library.services.LibraryService;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class AdminViewPanel extends JPanel {

    private DefaultTableModel model;

    public AdminViewPanel(LibraryService service) {

        setLayout(new BorderLayout());

        model = new DefaultTableModel(
                new String[]{"User ID", "Book ID", "Book Title", "Issue Date"}, 0);

        JTable table = new JTable(model);
        add(new JScrollPane(table), BorderLayout.CENTER);

        load(service);
    }

    public void load(LibraryService service) {

        model.setRowCount(0);

        for (Transaction t : service.getAllTransactions()) {

            Book b = service.getBookById(t.getBookId());

            model.addRow(new Object[]{
                    t.getUserId(),
                    b.getId(),
                    b.getTitle(),
                    t.getIssueDate()
            });
        }
    }
}
