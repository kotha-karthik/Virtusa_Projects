package com.iss.library;

import com.iss.library.frames.LoginFrame;
import com.iss.library.models.Book;
import com.iss.library.models.User;
import com.iss.library.services.LibraryService;

public class Main {
    public static void main(String[] args) {
//        LibraryService service = new LibraryService();
//
//        User admin = new User(1, "Karthik","Kotha", "ADMIN");
//        service.registerUser(admin);
//
//        service.addBook(new Book(101, "Java", "James","Virtusa"), admin);
//
//        service.issueBook(101, 1);
//        int fine = service.returnBook(101);
//
//        System.out.println("Fine: " + fine);

        new LoginFrame();

    }
}