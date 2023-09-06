package com.Gleb.controllers;

import com.Gleb.context.ContextContainer;
import com.Gleb.entities.Car;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class CarsController extends Controller {

    @Autowired
    private ContextContainer<Car> contextContainer;
    
    @GetMapping("/cars/{id}")
    protected Object doGet(@PathVariable int id) {
        return this.handleGet(id, this.contextContainer);
    }

    @Override
    @PostMapping("/cars")
    protected void doPost(HttpEntity<String> httpEntity) {
        this.handlePost(httpEntity, this.contextContainer);
    }

    @Override
    @PutMapping("/cars")
    protected void doPut(HttpEntity<String> httpEntity) {
        this.handlePut(httpEntity, this.contextContainer);
    }

    @Override
    @DeleteMapping("/cars/{id}")
    protected void doDelete(@PathVariable int id) {
        this.handleDelete(id, this.contextContainer);
    }
}
