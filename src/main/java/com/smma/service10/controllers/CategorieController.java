package com.smma.service10.controllers;

import com.smma.service10.entities.Categorie;
import com.smma.service10.entities.Product;
import com.smma.service10.services.CategorieService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public String categorieList(ModelMap modelMap) {
        List<Categorie> CategorieController = categorieService.getAllCategories();
        modelMap.addAttribute( "categoriesJsp", CategorieController);
        return "CategoriesList";
        }

    @RequestMapping("/deleteCategorie")
    public String deleteCategory(@RequestParam("id") Long id , ModelMap modelMap) {
        categorieService.deleteCategoryById(id);
        List<Categorie> categorieController = categorieService.getAllCategories();
        modelMap.addAttribute( "categoriesJsp", categorieController);
        return "CategoriesList";
    }
    @RequestMapping("/showCategorie")
    public String showCategorie(@RequestParam("id") Long id , ModelMap modelMap){
        Categorie categorieController = categorieService.getCategorieById(id);
        modelMap.addAttribute("categorieJsp", categorieController);
        return "EditCategorie";
    }

    @RequestMapping("/updateCategorie")
    public String updateCategorie(
            @ModelAttribute("categorie") Categorie categorie,
            ModelMap modelMap
    ) {
        Categorie memo = categorieService.saveCategorie(categorie);
        return "CategorieList"; // Return the name of the JSP file to display
    }

}
