package com.sameer.bookstore.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;

@Entity
@Data
@ToString
@EqualsAndHashCode
@Table(name = "book_order", schema = "public", catalog = "estore")
public class BookOrder {
    @Id
    @Column(name = "order_id", nullable = false)
    private Integer orderId;
    @Basic
    @Column(name = "order_date", nullable = false)
    private Timestamp orderDate;
    @Basic
    @Column(name = "shipping_address", nullable = false, length = 256)
    private String shippingAddress;
    @Basic
    @Column(name = "recipient_name", nullable = false, length = 30)
    private String recipientName;
    @Basic
    @Column(name = "recipient_phone", nullable = false, length = 15)
    private String recipientPhone;
    @Basic
    @Column(name = "payment_method", nullable = false, length = 20)
    private String paymentMethod;
    @Basic
    @Column(name = "total", nullable = false, precision = 0)
    private Double total;
    @Basic
    @Column(name = "status", nullable = false, length = 20)
    private String status;
    @ManyToOne
    @JoinColumn(name = "customer_id", referencedColumnName = "customer_id", nullable = false)
    private Customer customerByCustomerId;
    @OneToMany(mappedBy = "bookOrderByOrderId")
    private Collection<OrderDetail> orderDetailsByOrderId;

}
