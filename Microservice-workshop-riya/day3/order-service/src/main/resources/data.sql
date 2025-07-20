INSERT into orders (total_price, order_status) VALUES
(100.50, 'CANCELLED'),
(200.50, 'PENDING'),
(300.50, 'CONFIRMED');

--// Inserting order items
INSERT into order_item (order_id, product_id, quantity) VALUES
(1, 101, 2),
(2, 201, 6),
(2, 103, 9);