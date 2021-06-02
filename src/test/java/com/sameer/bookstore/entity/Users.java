package com.sameer.bookstore.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NamedQueries(value = {
        @NamedQuery(name = "Users.getAll", query = "SELECT u FROM Users u")
})
@Data
@Table(name = "users")
public class Users {
    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;
    @Column(name = "email")
    private String email;
    @Column(name = "password")
    private String password;
    @Column(name = "full_name")
    private String fullName;

}
