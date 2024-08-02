package com.example.demo.services;

import org.springframework.stereotype.Service;

@Service
public class ProductService {

    public int getAllRequest(){
        System.out.println("Got Get Request");
        return 1;
    }

    public void putRequest(){
        System.out.println("Got Put Request");
    }

    public int getRequest(Integer id){
        System.out.println("Got Get with id Request");
        return id;
    }
    
}
