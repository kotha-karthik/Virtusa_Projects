package com.iss.library.frames;

import com.iss.library.models.User;
import com.iss.library.services.LibraryService;

import javax.swing.*;
import java.awt.*;

class ReturnButtonEditor extends DefaultCellEditor {

    private JButton button;
    private int bookId;
    private LibraryService service;
    private User user;
    private IssuePanel panel;

    public ReturnButtonEditor(JCheckBox checkBox, LibraryService service, User user, IssuePanel panel) {
        super(checkBox);
        this.service = service;
        this.user = user;
        this.panel = panel;

        button = new JButton("Return");

        button.addActionListener(e -> {
            fireEditingStopped();

            try {
                service.returnBook(bookId, user.getId());
                JOptionPane.showMessageDialog(button, "Book Returned!");
                panel.load(service, user);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(button, ex.getMessage());
            }
        });
    }

    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        bookId = (int) table.getValueAt(row, 0);
        return button;
    }

    public Object getCellEditorValue() {
        return "Return";
    }
}

