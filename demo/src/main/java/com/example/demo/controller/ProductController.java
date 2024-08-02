package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.services.ProductService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
public class ProductController {
    
    private final ProductService productService;

    @GetMapping
    public Integer getAllRequest(){
        return productService.getAllRequest();
    }

    @PostMapping
    public void putRequest(){
        productService.putRequest();
    }

    @GetMapping("/{id}")
    public Integer getRequest( @PathVariable("id") Integer id ){
        return productService.getRequest(id);
    }



}
