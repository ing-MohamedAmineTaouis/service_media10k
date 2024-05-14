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
    public Product saveProduct(Product service) {
        return serviceRepository.save(service);
    }

    @Override
    public Product updateProduct(Product service) {
        return serviceRepository.save(service);
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
    public void deleteServiceById(Long id) {
        serviceRepository.deleteById(id);
    }

    @Override
    public void deleteAllServices() {
        serviceRepository.deleteAll();
    }


}
