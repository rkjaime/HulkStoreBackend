package com.co.cidenet.prueba.controllers;
/*
Created by : Jaime Mejia
*/

import com.co.cidenet.model.Product;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping({"/Products"})
class TestController {

    private final List<Product> Products = createList();

    @GetMapping(produces = "application/json")
    public List<Product> firstPage() {
        return Products;
    }

    @DeleteMapping(path = {"/{id}"})
    public Product delete(@PathVariable("id") int productId) {
        Product deletedProduct = null;
        for (Product product : Products) {
            if (product.getProductId().equals(productId)) {
                Products.remove(product);
                deletedProduct = product;
                break;
            }
        }
        return deletedProduct;
    }

    @PostMapping
    public Product create(@RequestBody Product user) {
        Products.add(user);
        System.out.println(Products);
        return user;
    }

    private static List<Product> createList() {
        List<Product> tempProducts = new ArrayList<>();
        Product emp1 = new Product();
        emp1.setName("emp1");
        emp1.setPrice(123);
        emp1.setProductId(1);
        emp1.setQuantity(3000);

        Product emp2 = new Product();
        emp2.setName("emp2");
        emp2.setPrice(123);
        emp2.setProductId(2);
        emp2.setQuantity(3000);
        tempProducts.add(emp1);
        tempProducts.add(emp2);
        return tempProducts;
    }

}