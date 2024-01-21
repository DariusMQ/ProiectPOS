package com.pos.proiectpos.entities;

import jakarta.persistence.*;

import java.util.Collection;

@Entity
public class Cart {
    @Id
    @GeneratedValue
    private Long id;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    @OneToOne
    private User owner;

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    @OneToOne
    private Receipt receipt;

    public Receipt getReceipt() {
        return receipt;
    }

    public void setReceipt(Receipt receipt) {
        this.receipt = receipt;
    }

    @OneToMany
    private Collection<Product_in_cart> products;

    public Collection<Product_in_cart> getProducts() {
        return products;
    }

    public void setProducts(Collection<Product_in_cart> products) {
        this.products = products;
    }
}
