package com.iss.library.frames;

import com.iss.library.models.Book;
import com.iss.library.models.User;
import com.iss.library.services.LibraryService;

import javax.swing.*;
import java.awt.*;

public class UpdateBookForm extends JFrame {

    public UpdateBookForm(LibraryService service, User user, Book book,Runnable onUpdate) {

        setTitle("Update Book");
        setSize(400, 300);
        setLayout(new GridLayout(6, 2, 10, 10));

        JTextField idField = new JTextField(String.valueOf(book.getId()));
        JTextField titleField = new JTextField(book.getTitle());
        JTextField authorField = new JTextField(book.getAuthor());
        JTextField publisherField = new JTextField(book.getPublisher());
        JTextField qtyField = new JTextField(String.valueOf(book.getQuantity()));

        idField.setEditable(false);

        add(new JLabel("ID:"));
        add(idField);

        add(new JLabel("Title:"));
        add(titleField);

        add(new JLabel("Author:"));
        add(authorField);

        add(new JLabel("Publisher:"));
        add(publisherField);

        add(new JLabel("Quantity:"));
        add(qtyField);

        JButton saveBtn = new JButton("Save");
        add(new JLabel());
        add(saveBtn);


        saveBtn.addActionListener(e -> {
            try {

                Book updatedBook = new Book(
                        book.getId(),
                        titleField.getText(),
                        authorField.getText(),
                        publisherField.getText(),
                        Integer.parseInt(qtyField.getText())
                );

                service.updateBookAdmin(updatedBook, user);

                JOptionPane.showMessageDialog(this, "Book Updated Successfully!");
                onUpdate.run();
                dispose();

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
            }
        });

        setLocationRelativeTo(null);
        setVisible(true);
    }
}
