package com.iss.library.frames;

import com.iss.library.models.User;
import com.iss.library.services.LibraryService;

import javax.swing.*;
import java.awt.*;

public class LoginFrame extends JFrame {

    private LibraryService service = new LibraryService();
    public static User loggedInUser;

    public LoginFrame() {
        setTitle("Library Login");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(6, 2, 10, 10));
        JTextField username = new JTextField();
        JPasswordField password = new JPasswordField();
        JButton login = new JButton("Login");
        JButton register = new JButton("Register");
        add(new JLabel("Username:"));
        add(username);
        add(new JLabel("Password:"));
        add(password);
        add(login);
        add(register);
        login.addActionListener(e -> {
            try {
                loggedInUser = service.login(
                        username.getText(),
                        new String(password.getPassword())
                );

                if (loggedInUser.getRole().equals("ADMIN")) {
                    new AdminDashboardFrame(service, loggedInUser);
                } else {
                    new DashboardFrame(service, loggedInUser);
                }

                dispose();

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage());
            }
        });
        register.addActionListener(e -> {
            String fname = JOptionPane.showInputDialog("First Name:");
            String lname = JOptionPane.showInputDialog("Last Name:");
            String uname = JOptionPane.showInputDialog("Username:");
            String pass = JOptionPane.showInputDialog("Password:");
            service.registerStudent(new User(0, fname, lname, uname, pass, "STUDENT"));
            JOptionPane.showMessageDialog(this, "Student Registered!");
        });
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }
}