package com.iss.library.frames;

import com.iss.library.models.User;
import com.iss.library.services.LibraryService;

import javax.swing.*;
import java.awt.*;

public class AdminDashboardFrame extends JFrame {

    public AdminDashboardFrame(LibraryService service, User user) {

        setTitle("Admin Dashboard");
        setSize(1100, 600);
        setLayout(new BorderLayout());
        setLocationRelativeTo(null);

        JLabel title = new JLabel("ADMIN PANEL - " + user.getUsername());
        title.setFont(new Font("Arial", Font.BOLD, 18));
        add(title, BorderLayout.NORTH);

        JPanel menu = new JPanel(new GridLayout(4, 1, 10, 10));

        JButton viewBtn = new JButton("View Issued Books");
        JButton addBtn = new JButton("Add Book");
        JButton updateBtn = new JButton("Update Book");

        menu.add(viewBtn);
        menu.add(addBtn);
        menu.add(updateBtn);

        add(menu, BorderLayout.WEST);

        JPanel container = new JPanel(new CardLayout());

        AdminViewPanel viewPanel = new AdminViewPanel(service);
        AddBookPanel addPanel = new AddBookPanel(service, user);
        UpdateBookPanel updatePanel = new UpdateBookPanel(service, user);

        container.add(viewPanel, "VIEW");
        container.add(addPanel, "ADD");
        container.add(updatePanel, "UPDATE");

        add(container, BorderLayout.CENTER);

        CardLayout cl = (CardLayout) container.getLayout();

        viewBtn.addActionListener(e -> {
            viewPanel.load(service);
            cl.show(container, "VIEW");
        });

        addBtn.addActionListener(e -> cl.show(container, "ADD"));
        updateBtn.addActionListener(e -> {
            //updatePanel.load(service);
            cl.show(container, "UPDATE");
        });

        setVisible(true);
    }
}
