DELETE FROM users;
INSERT INTO users (email,password,full_name) VALUES
('sameervogeti@gmail.com','Test#123,','sameer chandra vogeti');

/*
DELETE FROM customer;
INSERT INTO customer (email,fullname,address,city,country,phone,zipcode,password,register_date) VALUES
('sameervogeti@gmail.com',
 'sameer vogeti',
 'Banjara Hills',
 'Hyderabad',
 'India',
 '7004088860',
 '500026',
 'Kites#123',
 '2000-04-29 04:46:22.000');

DELETE FROM category;
INSERT INTO category (name) VALUES
('Fiction');

DELETE FROM book_order;
INSERT INTO book_order (customer_id,order_date,shipping_address,recipient_name,recipient_phone,payment_method,total,status) VALUES
(1,'2012-10-25 22:57:19.000','hyderabad','sameer','9398695280','card',500,'OUT_FOR_DELIVERY');

DELETE FROM book;
INSERT INTO book (title,author,description,isbn,image,price,publish_date,last_update_time,category_id) VALUES
('Count of Monte Cristo','Alexander Dumas','Tale of Forgiveness and Life','ISBN-0001110 ',NULL,10,'2007-03-01','1982-10-15 21:16:59.000',1);

DELETE FROM order_detail;
INSERT INTO order_detail (order_id,book_id,quantity,subtotal) VALUES
(1,1,1,10);

DELETE FROM review;
INSERT INTO review (book_id,customer_id,rating,headline,"comment",review_time) VALUES
(1,1,4,'Beautiful Book','Must Read','2019-06-11 19:32:20.000');*/