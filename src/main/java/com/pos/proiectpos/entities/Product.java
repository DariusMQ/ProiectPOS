package com.pos.proiectpos.entities;

import jakarta.persistence.*;

import java.util.Collection;

@Entity
public class Product {

    @Id
    @GeneratedValue
    private Long id;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    @Basic
    private String product_name;

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }


    @Basic
    private Float price;

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }


    @Basic
    private Long stock;

    public Long getStock() {
        return stock;
    }

    public void setStock(Long stock) {
        this.stock = stock;
    }


    @OneToMany(mappedBy = "product_in_stock")
    private Collection<Product_in_cart> product_in_cart;

    public Collection<Product_in_cart> getProduct_in_cart() {
        return product_in_cart;
    }

    public void setProduct_in_cart(Collection<Product_in_cart> product_in_cart) {
        this.product_in_cart = product_in_cart;
    }


    @OneToMany(mappedBy = "product_in_stock")
    private Collection<Product_in_receipt> product_in_receipt;

    public Collection<Product_in_receipt> getProduct_in_receipt() {
        return product_in_receipt;
    }

    public void setProduct_in_receipt(Collection<Product_in_receipt> product_in_receipt) {
        this.product_in_receipt = product_in_receipt;
    }
}
