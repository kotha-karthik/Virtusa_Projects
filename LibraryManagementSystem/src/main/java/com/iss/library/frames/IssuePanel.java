package com.iss.library.frames;

import com.iss.library.models.Book;
import com.iss.library.models.Transaction;
import com.iss.library.models.User;
import com.iss.library.services.LibraryService;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class IssuePanel extends JPanel {

    private DefaultTableModel model;
    public IssuePanel(LibraryService service, User user) {
        setLayout(new BorderLayout());
        model = new DefaultTableModel(
                new String[]{"Book ID", "Title", "Issue Date", "Due Date", "Fine", "Action"}, 0);
        JTable table = new JTable(model);
        table.getColumn("Action").setCellRenderer(new ButtonRenderer());
        table.getColumn("Action").setCellEditor(
                new ReturnButtonEditor(new JCheckBox(), service, user, this)
        );
        add(new JScrollPane(table), BorderLayout.CENTER);
        JButton refresh = new JButton("Refresh");
        add(refresh, BorderLayout.SOUTH);
        refresh.addActionListener(e -> load(service, user));
        load(service, user);
    }


    public void load(LibraryService service, User user) {
        model.setRowCount(0);
        for (Transaction t : service.getUserTransactions(user.getId())) {
            Book b = service.getBookById(t.getBookId());
            model.addRow(new Object[]{
                    b.getId(),
                    b.getTitle(),
                    t.getIssueDate(),
                    t.getDueDate(),
                    t.getFine(),
                    "Return"
            });
        }
    }
}


