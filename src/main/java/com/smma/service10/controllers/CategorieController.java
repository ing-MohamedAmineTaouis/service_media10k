package com.smma.service10.controllers;

import com.smma.service10.entities.Categorie;
import com.smma.service10.entities.Product;
import com.smma.service10.services.CategorieService;
import com.smma.service10.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class CategorieController {

    @Autowired
    private CategorieService categorieService;

    @RequestMapping("/createCategorie")
    public String createCategory(ModelMap modelMap) {
        modelMap.addAttribute("categorie", new Categorie()); // Initialize a new Categorie object
        return "CreateCategorie"; // Return the name of the JSP file to display
    }

    @RequestMapping("/saveCategorie")
    public String saveCategory(@ModelAttribute("categorie") Categorie categorie, ModelMap modelMap) {
        // Call the service method to save the category
        Categorie savedCategory = categorieService.saveCategorie(categorie);

        // Check if the category is saved successfully
        if (savedCategory != null) {
            modelMap.addAttribute("messageJsp", "Category saved successfully!");
        } else {
            modelMap.addAttribute("messageJsp", "Failed to save the category.");
        }

        return "CreateCategorie"; // Return the name of the JSP file to display
    }
    @RequestMapping("/categoriesList")
    public String categoriesList(ModelMap modelMap) {
        List<Categorie> categoriesController = categorieService.getAllCategories();
        modelMap.addAttribute( "categoriesJsp", categoriesController);
        return "CategoriesList";
        }

    @RequestMapping("/deleteCategorie")
    public String deleteCategory(@RequestParam("id") Long id, ModelMap modelMap) {
        try {
            categorieService.deleteCategoryById(id);
        } catch (DataIntegrityViolationException e) {
            modelMap.addAttribute("message", "Cannot delete category because it is referenced by existing products.");
        }

        List<Categorie> categorieController = categorieService.getAllCategories();
        modelMap.addAttribute("categoriesJsp", categorieController);
        return "CategoriesList";
    }

    @RequestMapping("/showCategorie")
    public String showCategorie(@RequestParam("id") Long id , ModelMap modelMap){
        Categorie categorieController = categorieService.getCategorieById(id);
        modelMap.addAttribute("categoriesJsp", categorieController);
        return "EditCategorie";
    }

    @RequestMapping("/updateCategorie")
    public String updateCategorie(
            @ModelAttribute("categorie") Categorie categorie,
            ModelMap modelMap
    ) {
        // Retrieve the existing product from the database using its ID
        Categorie existingCategorie = categorieService.getCategorieById(categorie.getIdCategorie());

        // Update the existing product with the new data
        existingCategorie.setNomCategorie(categorie.getNomCategorie());
        // Save the updated product
        categorieService.saveCategorie(existingCategorie);

        return "redirect:/categoriesList"; // Redirect to the products list page
    }

}
