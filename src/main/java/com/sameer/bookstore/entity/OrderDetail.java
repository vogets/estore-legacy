package com.sameer.bookstore.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Data
@ToString
@EqualsAndHashCode
@Table(name = "order_detail", schema = "public", catalog = "estore")
public class OrderDetail {
    @Id
    @Column(name = "id", nullable = false)
    private Integer orderDetailId;
    @Basic
    @Column(name = "quantity", nullable = false)
    private Integer quantity;
    @Basic
    @Column(name = "subtotal", nullable = false, precision = 0)
    private Double subtotal;
    @ManyToOne
    @JoinColumn(name = "order_id", referencedColumnName = "order_id")
    private BookOrder bookOrderByOrderId;
    @ManyToOne
    @JoinColumn(name = "book_id", referencedColumnName = "book_id")
    private Book bookByBookId;

}
