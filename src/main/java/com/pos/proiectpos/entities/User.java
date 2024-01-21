package com.pos.proiectpos.entities;

import jakarta.persistence.*;

@Entity
public class User {
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
    private String username;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    private String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    private String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @OneToOne(mappedBy = "owner")
    private Cart cart_id;

    public Cart getCart_id() {
        return cart_id;
    }

    public void setCart_id(Cart cart_id) {
        this.cart_id = cart_id;
    }
}
