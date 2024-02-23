package com.pos.proiectpos.common;

import com.pos.proiectpos.entities.Cart;

public class UserDto {
    private Long id;
    private String username;
    private String email;
    private String password;
    private Cart cart_id;

    public UserDto(Long id, String username, String email, String password, Cart cart_id) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.cart_id = cart_id;
    }

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public Cart getCart_id() {
        return cart_id;
    }
}
