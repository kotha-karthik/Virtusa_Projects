package com.iss.library.frames;

import com.iss.library.models.Book;
import com.iss.library.models.User;
import com.iss.library.services.LibraryService;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class BookPanel extends JPanel {

    private DefaultTableModel model;

    public BookPanel(LibraryService service, User user) {

        setLayout(new BorderLayout());

        model = new DefaultTableModel(
                new String[]{"ID", "Title", "Author", "Publisher", "Available", "Action"}, 0);

        JTable table = new JTable(model);

        table.getColumn("Action").setCellRenderer(new ButtonRenderer());
        table.getColumn("Action").setCellEditor(
                new AssignButtonEditor(new JCheckBox(), service, user, this)
        );

        add(new JScrollPane(table), BorderLayout.CENTER);

        JButton refresh = new JButton("Refresh");
        add(refresh, BorderLayout.SOUTH);

        refresh.addActionListener(e -> load(service));

        load(service);
    }

    public void load(LibraryService service) {
        model.setRowCount(0);

        for (Book b : service.getAllBooks()) {
            model.addRow(new Object[]{
                    b.getId(),
                    b.getTitle(),
                    b.getAuthor(),
                    b.getPublisher(),
                    b.getAvailableQty(),
                    "Assign"
            });
        }
    }
}

