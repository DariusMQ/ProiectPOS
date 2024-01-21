package com.pos.proiectpos.entities;

import jakarta.persistence.*;

import java.util.Collection;

@Entity
public class Product_in_cart {
    @Id
    @GeneratedValue
    private Long id;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    private Long quantity;

    public void setQuantity(Long quantity){
        this.quantity=quantity;
    }

    public Long getQuantity(){
        return quantity;
    }

    @ManyToOne
    private Cart owning_cart;

    public Cart getOwning_cart() {
        return owning_cart;
    }

    public void setOwning_cart(Cart owning_cart) {
        this.owning_cart = owning_cart;
    }

    @ManyToOne
    private Product product_in_stock;

    public Product getProduct_in_stock() {
        return product_in_stock;
    }

    public void setProduct_in_stock(Product product_in_stock) {
        this.product_in_stock = product_in_stock;
    }

}
