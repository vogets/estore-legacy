delete
from users;
insert into users (email,
                   password,
                   full_name)
values ('sameervogeti@gmail.com',
        'Test#123,',
        'sameer chandra vogeti');
delete
from customer;
insert into customer (customer_id,email,
                      fullname,
                      address,
                      city,
                      country,
                      phone,
                      zipcode,
                      password,
                      register_date)
values (1,'sameervogeti@gmail.com',
        'sameer vogeti',
        'Banjara Hills',
        'Hyderabad',
        'India',
        '7004088860',
        '500026',
        'Kites#123',
        '2000-04-29 04:46:22.000');
delete
from category;
insert into category (name)
values ('Fiction');
delete
from book_order;
insert into book_order (customer_id,
                        order_date,
                        shipping_address,
                        recipient_name,
                        recipient_phone,
                        payment_method,
                        total,
                        status)
values (1,
        '2012-10-25 22:57:19.000',
        'hyderabad',
        'sameer',
        '9398695280',
        'card',
        '500',
        'OUT_FOR_DELIVERY');

/*
delete
from book;
insert into book (title,
                  author,
                  description,
                  isbn,
                  image,
                  price,
                  publish_date,
                  last_update_time,
                  category_id)
values ('Count of Monte Cristo',
        'Alexander Dumas',
        'Tale of Forgiveness and Life',
        'ISBN-0001110 ',
        '013d7d16d7ad4fefb61bd95b765c8ceb',
        '10',
        '2007-03-01',
        '1982-10-15 21:16:59.000',
        1);*/
/*
delete
from order_detail;
insert into order_detail (order_id,
                          book_id,
                          quantity,
                          subtotal)
values (1,
        1,
        1,
        10);*/
/*
delete
from review;
insert into review (book_id,
                    customer_id,
                    rating,
                    headline,
                    comment,
                    review_time)
values (1,
        1,
        4,
        'Beautiful Book',
        'Must Read',
        '2019-06-11 19:32:20.000');*/