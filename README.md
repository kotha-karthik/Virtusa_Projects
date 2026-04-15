Multi-Project Repository: Python, SQL & Java Systems

Welcome to this repository! This repo contains three complete projects across different technologies—Python, SQL, and Java—designed to demonstrate practical problem-solving, clean architecture, and real-world application development.

Projects Included
1. Smart Expense Tracker with Insights (Python)
Overview

A command-line based Python application that helps users track daily expenses, analyze spending habits, and gain insights into financial behavior.

Features
Add daily expenses (date, category, amount, description)
Categorize expenses (Food, Travel, Bills, etc.)
Monthly expense summary
Category-wise breakdown using pie charts
Detect highest spending category
Tech Stack
Python
CSV / JSON for data storage
matplotlib for visualization

-->How to Run
python expense_tracker.py

-->Key Concepts Used
File handling (CSV/JSON)
Data aggregation
Visualization using matplotlib
CLI-based user interaction


2. Online Retail Sales Analysis Database (SQL)
Overview

A structured relational database system designed to analyze retail sales data and generate meaningful business insights.


-->Database Schema

Customers (customer_id, name, city)
Products (product_id, name, category, price)
Orders (order_id, customer_id, date)
Order_Items (order_id, product_id, quantity)

-->Key Queries Implemented
Top-selling products
Most valuable customers
Monthly revenue calculation
Category-wise sales analysis
Inactive customers detection

-->Tech Stack
MySQL / PostgreSQL
SQL Joins (INNER, LEFT, GROUP BY, HAVING)
Aggregate Functions

-->How to Run
Create database
Execute schema.sql
Run queries.sql

-->Key Concepts Used
Relational database design
SQL joins & aggregations
Data analysis using queries

3. Library Management System (Java)
Overview

A GUI-based Java application built using Swing that automates library operations such as managing books, issuing/returning records, and calculating fines. The graphical interface makes the system user-friendly and closer to real-world applications compared to console-based systems.

-->Features
Add, update, delete books
User registration system
Issue & return books with due dates
Fine calculation for late returns
Search books by title/author

-->Tech Stack
Core Java (OOP)
Optional: JDBC + MySQL
Console-based interface

-->How to Run
javac Main.java
java Main

-->Key Concepts Used
Object-Oriented Programming (OOP)
Classes & Objects
Exception handling
Collections 
