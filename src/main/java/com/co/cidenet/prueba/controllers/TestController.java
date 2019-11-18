package com.co.cidenet.prueba.controllers;
/*
Created by : Jaime Mejia
*/

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.co.cidenet.model.Product;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping({"/Products"})
public class TestController {

    private List<Product> Products = createList();

    @GetMapping(produces = "application/json")
    public List<Product> firstPage() {
        return Products;
    }

    @DeleteMapping(path = {"/{id}"})
    public Product delete(@PathVariable("id") int id) {
        Product deletedEmp = null;
        for (Product emp : Products) {
            if (emp.getProductId().equals(id)) {
                Products.remove(emp);
                deletedEmp = emp;
                break;
            }
        }
        return deletedEmp;
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
        emp1.setProductId("1");
        emp1.setQuantity(3000);

        Product emp2 = new Product();
        emp2.setName("emp2");
        emp2.setPrice(123);
        emp2.setProductId("2");
        emp2.setQuantity(3000);
        tempProducts.add(emp1);
        tempProducts.add(emp2);
        return tempProducts;
    }

}