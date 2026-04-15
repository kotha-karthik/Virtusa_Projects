-- For Customers
INSERT INTO customers VALUES (1, 'Rahul', 'Hyderabad');
INSERT INTO customers VALUES (2, 'Anita', 'Mumbai');
INSERT INTO customers VALUES (3, 'Kiran', 'Delhi');

-- For Products
INSERT INTO products VALUES (101, 'Laptop', 'Electronics', 60000);
INSERT INTO products VALUES (102, 'Mobile', 'Electronics', 20000);
INSERT INTO products VALUES (103, 'Shoes', 'Fashion', 3000);
INSERT INTO products VALUES (104, 'Watch', 'Accessories', 5000);

-- For Orders
INSERT INTO orders VALUES (1001, 1, DATE '2025-01-10');
INSERT INTO orders VALUES (1002, 2, DATE '2025-02-15');
INSERT INTO orders VALUES (1003, 1, DATE '2025-03-05');

-- For Order Items
INSERT INTO order_items VALUES (1001, 101, 1);
INSERT INTO order_items VALUES (1001, 103, 2);
INSERT INTO order_items VALUES (1002, 102, 1);
INSERT INTO order_items VALUES (1003, 104, 3);

COMMIT;
