package com.pos.proiectpos.common;

public class ProductDto {
    private Long id;
    private String product_name;
    private Long stock;
    private Float price;

    public ProductDto(Long id, String product_name, Long stock, Float price) {
        this.id = id;
        this.product_name = product_name;
        this.stock = stock;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public String getProduct_name() {
        return product_name;
    }

    public Long getStock() {
        return stock;
    }

    public Float getPrice() {
        return price;
    }


}


