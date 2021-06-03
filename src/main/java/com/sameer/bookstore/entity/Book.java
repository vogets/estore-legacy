package com.sameer.bookstore.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.Collection;

@Entity
@Data
@ToString
@EqualsAndHashCode
public class Book {
    @Id
    @Column(name = "book_id", nullable = false)
    private Integer bookId;
    @Basic
    @Column(name = "title", nullable = false, length = 128)
    private String title;
    @Basic
    @Column(name = "author", nullable = false, length = 64)
    private String author;
    @Basic
    @Column(name = "description", nullable = false, length = -1)
    private String description;
    @Basic
    @Column(name = "isbn", nullable = false, length = 15)
    private String isbn;
    @Basic
    @Column(name = "image", nullable = false)
    private byte[] image;
    @Basic
    @Column(name = "price", nullable = false)
    private Double price;
    @Basic
    @Column(name = "publish_date", nullable = false)
    private Timestamp publishDate;
    @Basic
    @Column(name = "last_update_time", nullable = false)
    private Timestamp lastUpdateTime;
    @ManyToOne
    @JoinColumn(name = "category_id", referencedColumnName = "category_id", nullable = false)
    private Category categoryByCategoryId;
    @OneToMany(mappedBy = "bookByBookId")
    private Collection<OrderDetail> orderDetailsByBookId;
    @OneToMany(mappedBy = "bookByBookId")
    private Collection<Review> reviewsByBookId;
}
