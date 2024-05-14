package com.smma.service10.services;

import com.smma.service10.entities.Categorie;
import com.smma.service10.entities.Product;

import java.util.List;

public interface CategorieService {
    List<Categorie> getAllCategories();

    Categorie saveCategorie(Categorie categorie);

    void deleteCategoryById(Long id);

    Categorie getCategorieById(Long id);

    Categorie updateCategorie(Categorie categorie);
}
