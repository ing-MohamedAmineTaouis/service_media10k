package com.smma.service10.controllers;

import com.smma.service10.entities.Product;
import com.smma.service10.entities.Categorie;
import com.smma.service10.services.CategorieService;
import com.smma.service10.services.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private CategorieService categorieService;

    @RequestMapping("/createProduct")
    public String createProduct(ModelMap modelMap) {
        List<Categorie> categories = categorieService.getAllCategories();
        modelMap.addAttribute("categories", categories);
        return "CreateProduct";
    }

    @RequestMapping("/saveProduct")
    public String saveProduct(@Valid Product product, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "CreateProduct";
        } else {
            productService.saveProduct(product);
            return "CreateProduct";
        }
    }
    @RequestMapping("/productsList")
    public String productsList(ModelMap modelMap) {
        List<Product> productsController = productService.getAllProducts();
        modelMap.addAttribute( "productsJsp", productsController);
        return "ProductsList";
    }

    @RequestMapping("/deleteProduct")
    public String deleteProduct(@RequestParam("id") Long id , ModelMap modelMap) {
        productService.deleteProductById(id);
        List<Product> productsController = productService.getAllProducts();
        modelMap.addAttribute( "productsJsp", productsController);
        return "ProductsList";
    }
    @RequestMapping("/showProduct")
    public String showProduct(@RequestParam("id") Long id , ModelMap modelMap){
        Product productController = productService.getProductById(id);
        modelMap.addAttribute("productJsp", productController);
        List<Categorie> categorieController = categorieService.getAllCategories();
        modelMap.addAttribute( "categories", categorieController);
        return "EditProduct";
    }

    @RequestMapping("/updateProduct")
    public String updateProduct(
            @ModelAttribute("product") Product product,
            ModelMap modelMap
    ) {
        // Retrieve the existing product from the database using its ID
        Product existingProduct = productService.getProductById(product.getIdProduct());

        // Update the existing product with the new data
        existingProduct.setNomProduct(product.getNomProduct());
        existingProduct.setPrixProduct(product.getPrixProduct());
        existingProduct.setCategorieProduct(product.getCategorieProduct());

        // Save the updated product
        productService.saveProduct(existingProduct);

        return "redirect:/productsList"; // Redirect to the products list page
    }





}

