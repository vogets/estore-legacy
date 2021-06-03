package com.sameer.bookstore.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import java.sql.Timestamp;

@Data
@ToString
@EqualsAndHashCode
@Entity
public class Review {
    @Id
    @Column(name = "review_id", nullable = false)
    private Integer reviewId;
    @Basic
    @Column(name = "rating", nullable = false)
    private Integer rating;
    @Basic
    @Column(name = "headline", nullable = false, length = 128)
    private String headline;
    @Basic
    @Column(name = "comment", nullable = false, length = 500)
    private String comment;
    @Basic
    @Column(name = "review_time", nullable = false)
    private Timestamp reviewTime;
    @ManyToOne
    @JoinColumn(name = "book_id", referencedColumnName = "book_id", nullable = false)
    private Book bookByBookId;
    @ManyToOne
    @JoinColumn(name = "customer_id", referencedColumnName = "customer_id", nullable = false)
    private Customer customerByCustomerId;

}
