package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.model.Product;
import com.example.demo.repository.ProductRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public void saveProduct(Product product) {
        productRepository.save(product);
    }

    public List<Product> getAllProducts() {

        return productRepository.findAll();
    }

    public Optional<Product> getProductById(Integer id) {
        return productRepository.findById(id);
    }

    public Product updateProductById(Integer id, Product productDetails) {

        Optional<Product> optionalProduct = productRepository.findById(id);
        if(optionalProduct.isPresent()){
            Product _product = optionalProduct.get();
            _product.setProductName(productDetails.getProductName());
            _product.setProductDescription(productDetails.getProductDescription());
            _product.setPrice(productDetails.getPrice());
            return productRepository.save(_product);
        }
        return null;
    }

    public void deleteProductById(Integer id) {

        productRepository.deleteById(id);
    }



    
}
