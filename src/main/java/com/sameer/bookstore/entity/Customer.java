package com.sameer.bookstore.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;

@Entity
@Data
@EqualsAndHashCode
@ToString
public class Customer {
    @Id
    @Column(name = "customer_id", nullable = false)
    private Integer customerId;
    @Basic
    @Column(name = "email", nullable = false, length = 64)
    private String email;
    @Basic
    @Column(name = "fullname", nullable = false, length = 30)
    private String fullname;
    @Basic
    @Column(name = "address", nullable = false, length = 128)
    private String address;
    @Basic
    @Column(name = "city", nullable = false, length = 32)
    private String city;
    @Basic
    @Column(name = "country", nullable = false, length = 64)
    private String country;
    @Basic
    @Column(name = "phone", nullable = false, length = 15)
    private String phone;
    @Basic
    @Column(name = "zipcode", nullable = false, length = 24)
    private String zipcode;
    @Basic
    @Column(name = "password", nullable = false, length = 16)
    private String password;
    @Basic
    @Column(name = "register_date", nullable = false)
    private Timestamp registerDate;
    @OneToMany(mappedBy = "customerByCustomerId")
    private Collection<BookOrder> bookOrdersByCustomerId;
    @OneToMany(mappedBy = "customerByCustomerId")
    private Collection<Review> reviewsByCustomerId;

}
