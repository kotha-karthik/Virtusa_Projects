package com.iss.library.frames;

import com.iss.library.models.User;
import com.iss.library.services.LibraryService;

import javax.swing.*;
import java.awt.*;

class AssignButtonEditor extends DefaultCellEditor {

    private JButton button;
    private int bookId;
    private LibraryService service;
    private User user;
    private BookPanel panel;

    public AssignButtonEditor(JCheckBox checkBox, LibraryService service, User user, BookPanel panel) {
        super(checkBox);
        this.service = service;
        this.user = user;
        this.panel = panel;

        button = new JButton("Assign");

        button.addActionListener(e -> {
            fireEditingStopped();

            try {
                service.issueBook(bookId, user.getId());
                JOptionPane.showMessageDialog(button, "Book Assigned!");
                panel.load(service); // refresh
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(button, ex.getMessage());
            }
        });
    }

    public Component getTableCellEditorComponent(JTable table, Object value,
                                                 boolean isSelected, int row, int column) {
        bookId = (int) table.getValueAt(row, 0);
        return button;
    }

    public Object getCellEditorValue() {
        return "Assign";
    }
}
