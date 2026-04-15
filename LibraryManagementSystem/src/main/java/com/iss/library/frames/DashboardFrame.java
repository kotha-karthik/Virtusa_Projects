package com.iss.library.frames;
import com.iss.library.models.User;
import com.iss.library.services.LibraryService;

import javax.swing.*;
import java.awt.*;

public class DashboardFrame extends JFrame {

    public DashboardFrame(LibraryService service, User user) {

        setTitle("Library Dashboard");
        setSize(1000, 600);
        setLayout(new BorderLayout());
        setLocationRelativeTo(null);
        JLabel title = new JLabel("Welcome " + user.getUsername());
        title.setFont(new Font("Arial", Font.BOLD, 18));
        add(title, BorderLayout.NORTH);
        JPanel menu = new JPanel(new GridLayout(3, 1, 10, 10));
        JButton booksBtn = new JButton("Books");
        JButton issueBtn = new JButton("My Books");
        menu.add(booksBtn);
        menu.add(issueBtn);
        add(menu, BorderLayout.WEST);
        JPanel container = new JPanel(new CardLayout());
        BookPanel bookPanel = new BookPanel(service, user);
        IssuePanel issuePanel = new IssuePanel(service, user);
        container.add(bookPanel, "BOOKS");
        container.add(issuePanel, "ISSUE");
        add(container, BorderLayout.CENTER);
        CardLayout cl = (CardLayout) container.getLayout();

        booksBtn.addActionListener(e -> cl.show(container, "BOOKS"));
        issueBtn.addActionListener(e -> {
            issuePanel.load(service, user);
            cl.show(container, "ISSUE");
        });

        setVisible(true);
    }
}