package com.sameer.bookstore.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import java.util.Collection;

@Data
@EqualsAndHashCode
@ToString
@Entity
public class Category {
    @Id
    @Column(name = "category_id", nullable = false)
    private Integer categoryId;
    @Basic
    @Column(name = "name", nullable = false, length = 30)
    private String name;
    @OneToMany(mappedBy = "categoryByCategoryId")
    private Collection<Book> booksByCategoryId;

}
