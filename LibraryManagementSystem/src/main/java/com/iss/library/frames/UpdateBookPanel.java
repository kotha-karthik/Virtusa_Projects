package com.iss.library.frames;

import com.iss.library.models.Book;
import com.iss.library.models.User;
import com.iss.library.services.LibraryService;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class UpdateBookPanel extends JPanel {

    private DefaultTableModel model;

    public UpdateBookPanel(LibraryService service, User user) {

        setLayout(new BorderLayout());

        model = new DefaultTableModel(
                new String[]{"ID", "Title", "Author", "Publisher", "Qty"}, 0
        );

        JTable table = new JTable(model);
        add(new JScrollPane(table), BorderLayout.CENTER);
        loadBooks(service);
        for (Book b : service.getAllBooks()) {
            model.addRow(new Object[]{
                    b.getId(),
                    b.getTitle(),
                    b.getAuthor(),
                    b.getPublisher(),
                    b.getQuantity()
            });
        }

        JButton updateBtn = new JButton("Update Selected");
        add(updateBtn, BorderLayout.SOUTH);

        updateBtn.addActionListener(e -> {

            int row = table.getSelectedRow();

            if (row == -1) {
                JOptionPane.showMessageDialog(this, "Select a row!");
                return;
            }

            Book b = new Book(
                    (int) model.getValueAt(row, 0),
                    model.getValueAt(row, 1).toString(),
                    model.getValueAt(row, 2).toString(),
                    model.getValueAt(row, 3).toString(),
                    Integer.parseInt(model.getValueAt(row, 4).toString())
            );
            new UpdateBookForm(service, user, b, () -> loadBooks(service));
        });
    }
    private void loadBooks(LibraryService service) {
        model.setRowCount(0);

        for (Book b : service.getAllBooks()) {
            model.addRow(new Object[]{
                    b.getId(),
                    b.getTitle(),
                    b.getAuthor(),
                    b.getPublisher(),
                    b.getQuantity()
            });
        }
    }
}
