package com.smma.service10.services;

import com.smma.service10.entities.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {
    Product updateProduct(Product product);

    void    deleteProductById(Long id);
    void    deleteAllProducts();

    Product saveProduct(Product product);


    List<Product> getAllProducts();

    Product getProductById(Long id);
}
