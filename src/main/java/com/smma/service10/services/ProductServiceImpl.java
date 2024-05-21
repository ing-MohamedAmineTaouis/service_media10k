package com.smma.service10.services;

import com.smma.service10.entities.Product;
import com.smma.service10.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service // Add @Service annotation to declare it as a Spring-managed service
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductRepository serviceRepository;
    @Override
    public Product saveProduct(Product product) {
        return serviceRepository.save(product);
    }

    @Override
    public Product updateProduct(Product product) {
        return serviceRepository.save(product);
    }

    @Override
    public Product getProductById(Long id) {
        return serviceRepository.findById(id).get();
    }

    @Override
    public List<Product> getAllProducts() {
        return serviceRepository.findAll();
    }


    @Override
    public void deleteProductById(Long id) {
        serviceRepository.deleteById(id);
    }

    @Override
    public void deleteAllProducts() {
        serviceRepository.deleteAll();
    }


}
