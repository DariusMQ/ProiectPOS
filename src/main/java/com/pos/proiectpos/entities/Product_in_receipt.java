package com.pos.proiectpos.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Product_in_receipt {
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
    private Receipt owning_receipt;

    public Receipt getOwning_receipt() {
        return owning_receipt;
    }

    public void setOwning_receipt(Receipt owning_receipt) {
        this.owning_receipt = owning_receipt;
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
