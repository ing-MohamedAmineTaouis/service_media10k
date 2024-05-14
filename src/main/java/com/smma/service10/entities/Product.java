package com.smma.service10.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
public class Product {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProduct;
    @NotNull
    @Size(min = 3 , max = 20)
    private String nomProduct;
    private String descriptionProduct;
    @NotNull
    private Double prixProduct;
    @ManyToOne
    private Categorie categorieProduct;

    @Override
    public String toString() {
        return "Product{" +
                "idProduct=" + idProduct +
                ", nomProduct='" + nomProduct + '\'' +
                ", descriptionProduct='" + descriptionProduct + '\'' +
                ", prixProduct=" + prixProduct +
                ", categorieProduct=" + categorieProduct +
                '}';
    }

    public Product() {
        super();
    }

    public Product(String nomProduct, String descriptionProduct, Double prixProduct, Categorie categorieProduct) {
        this.nomProduct = nomProduct;
        this.descriptionProduct = descriptionProduct;
        this.prixProduct = prixProduct;
        this.categorieProduct = categorieProduct;
    }

    public Long getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(Long idProduct) {
        this.idProduct = idProduct;
    }

    public String getNomProduct() {
        return nomProduct;
    }

    public void setNomProduct(String nomProduct) {
        this.nomProduct = nomProduct;
    }

    public String getDescriptionProduct() {
        return descriptionProduct;
    }

    public void setDescriptionProduct(String descriptionProduct) {
        this.descriptionProduct = descriptionProduct;
    }

    public Double getPrixProduct() {
        return prixProduct;
    }

    public void setPrixProduct(Double prixProduct) {
        this.prixProduct = prixProduct;
    }

    public Categorie getCategorieProduct() {
        return categorieProduct;
    }

    public void setCategorieProduct(Categorie categorieProduct) {
        this.categorieProduct = categorieProduct;
    }
}
