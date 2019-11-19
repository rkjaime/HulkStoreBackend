package com.co.cidenet.model;
/*
Created by : Jaime Mejia
*/

public class Product {
    private Integer productId;
    private String name;
    private Integer price;
    private Integer quantity;
    private String category;

    public Product() {
        // Do nothing because it's a constructor
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {

        this.name = name;

    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public boolean quantityValidate(int quantity) {
        return quantity >= 0;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Product other = (Product) obj;
        if (price == null) {
            if (other.price != null)
                return false;
        } else if (!price.equals(other.price))
            return false;
        if (productId == null) {
            if (other.productId != null)
                return false;
        } else if (!productId.equals(other.productId))
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        }
        return false;
    }
}
