CREATE SEQUENCE users_seq;

CREATE TABLE users
(
    user_id   int         NOT NULL DEFAULT NEXTVAL('users_seq'),
    email     varchar(30) NOT NULL,
    password  varchar(16) NOT NULL,
    full_name varchar(30) NOT NULL,
    PRIMARY KEY (user_id),
    CONSTRAINT user_id_UNIQUE UNIQUE (user_id)
);

ALTER SEQUENCE users_seq RESTART WITH 19;

CREATE SEQUENCE category_seq;

CREATE TABLE category
(
    category_id int         NOT NULL DEFAULT NEXTVAL('category_seq'),
    name        varchar(30) NOT NULL,
    PRIMARY KEY (category_id),
    CONSTRAINT category_id_UNIQUE UNIQUE (category_id)
);

ALTER SEQUENCE category_seq RESTART WITH 11;

CREATE SEQUENCE book_seq;

CREATE TABLE book
(
    book_id          int              NOT NULL DEFAULT NEXTVAL('book_seq'),
    title            varchar(128)     NOT NULL,
    author           varchar(64)      NOT NULL,
    description      text             NOT NULL,
    isbn             varchar(15)      NOT NULL,
    image            bytea            NOT NULL,
    price            double precision NOT NULL,
    publish_date     date             NOT NULL,
    last_update_time timestamp(0)     NOT NULL,
    category_id      int              NOT NULL,
    PRIMARY KEY (book_id),
    CONSTRAINT book_id_UNIQUE UNIQUE (book_id),
    CONSTRAINT title_UNIQUE UNIQUE (title),
    CONSTRAINT category_fk FOREIGN KEY (category_id) REFERENCES category (category_id) ON DELETE cascade ON UPDATE cascade
);

ALTER SEQUENCE book_seq RESTART WITH 32;

CREATE
INDEX category_fk_idx ON book (category_id);


CREATE SEQUENCE customer_seq;

CREATE TABLE customer
(
    customer_id   int          NOT NULL DEFAULT NEXTVAL('customer_seq'),
    email         varchar(64)  NOT NULL,
    fullname      varchar(30)  NOT NULL,
    address       varchar(128) NOT NULL,
    city          varchar(32)  NOT NULL,
    country       varchar(64)  NOT NULL,
    phone         varchar(15)  NOT NULL,
    zipcode       varchar(24)  NOT NULL,
    password      varchar(16)  NOT NULL,
    register_date timestamp(0) NOT NULL,
    PRIMARY KEY (customer_id),
    CONSTRAINT customer_id_UNIQUE UNIQUE (customer_id),
    CONSTRAINT email_UNIQUE UNIQUE (email)
);

ALTER SEQUENCE customer_seq RESTART WITH 11;


CREATE SEQUENCE review_seq;

CREATE TABLE review
(
    review_id   int          NOT NULL DEFAULT NEXTVAL('review_seq'),
    book_id     int          NOT NULL,
    customer_id int          NOT NULL,
    rating      int          NOT NULL,
    headline    varchar(128) NOT NULL,
    comment     varchar(500) NOT NULL,
    review_time timestamp(0) NOT NULL,
    PRIMARY KEY (review_id),
    CONSTRAINT review_id_UNIQUE UNIQUE (review_id),
    CONSTRAINT book_fk FOREIGN KEY (book_id) REFERENCES book (book_id) ON DELETE cascade ON UPDATE cascade,
    CONSTRAINT customer_fk FOREIGN KEY (customer_id) REFERENCES customer (customer_id) ON DELETE cascade ON UPDATE cascade
);

ALTER SEQUENCE review_seq RESTART WITH 15;

CREATE
INDEX book_fk_idx ON review (book_id);
CREATE
INDEX customer_fk_idx ON review (customer_id);

CREATE SEQUENCE book_order_seq;

CREATE TABLE book_order
(
    order_id         int              NOT NULL DEFAULT NEXTVAL('book_order_seq'),
    customer_id      int              NOT NULL,
    order_date       timestamp(0)     NOT NULL,
    shipping_address varchar(256)     NOT NULL,
    recipient_name   varchar(30)      NOT NULL,
    recipient_phone  varchar(15)      NOT NULL,
    payment_method   varchar(20)      NOT NULL,
    total            double precision NOT NULL,
    status           varchar(20)      NOT NULL,
    PRIMARY KEY (order_id),
    CONSTRAINT order_id_UNIQUE UNIQUE (order_id),
    CONSTRAINT customer_fk_2 FOREIGN KEY (customer_id) REFERENCES customer (customer_id) ON DELETE cascade ON UPDATE cascade
);

ALTER SEQUENCE book_order_seq RESTART WITH 22;

CREATE
INDEX customer_fk_2_idx ON book_order (customer_id);

CREATE TABLE order_detail
(
    order_id int DEFAULT NULL,
    book_id  int DEFAULT NULL,
    quantity int              NOT NULL,
    subtotal double precision NOT NULL,
    CONSTRAINT book_fk_2 FOREIGN KEY (book_id) REFERENCES book (book_id) ON DELETE cascade ON UPDATE cascade,
    CONSTRAINT order_fk FOREIGN KEY (order_id) REFERENCES book_order (order_id) ON DELETE cascade ON UPDATE cascade
);

CREATE
INDEX order_fk_idx ON order_detail (order_id);
CREATE
INDEX book_fk_2_idx ON order_detail (book_id);