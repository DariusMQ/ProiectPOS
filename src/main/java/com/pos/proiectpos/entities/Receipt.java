package com.pos.proiectpos.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collection;

@Entity
public class Receipt {
    @Id
    @GeneratedValue
    private Long id;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    private LocalDateTime time;


    @ManyToOne
    private User owner;

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }


    @OneToMany
    private Collection<Product_in_receipt> products;

    public Collection<Product_in_receipt> getProducts() {
        return products;
    }

    public void setProducts(Collection<Product_in_receipt> products) {
        this.products = products;
    }
}
