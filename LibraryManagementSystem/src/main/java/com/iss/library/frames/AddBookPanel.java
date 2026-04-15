package com.iss.library.frames;

import com.iss.library.models.Book;
import com.iss.library.models.User;
import com.iss.library.services.LibraryService;

import javax.swing.*;
import java.awt.*;

public class AddBookPanel extends JPanel {

    public AddBookPanel(LibraryService service, User user) {

        setLayout(new GridLayout(6, 2, 10, 10));

        JTextField title = new JTextField();
        JTextField author = new JTextField();
        JTextField publisher = new JTextField();
        JTextField qty = new JTextField();

        JButton add = new JButton("Add Book");

        add(new JLabel("Title:"));
        add(title);

        add(new JLabel("Author:"));
        add(author);

        add(new JLabel("Publisher:"));
        add(publisher);

        add(new JLabel("Quantity:"));
        add(qty);

        add(new JLabel(""));
        add(add);

        add.addActionListener(e -> {
            try {
                Book b = new Book(
                        0,
                        title.getText(),
                        author.getText(),
                        publisher.getText(),
                        Integer.parseInt(qty.getText())
                );

                service.addBook(b, user);

                JOptionPane.showMessageDialog(this, "Book Added!");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage());
            }
        });
    }
}
