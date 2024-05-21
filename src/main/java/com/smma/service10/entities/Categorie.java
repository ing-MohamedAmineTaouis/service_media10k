package com.smma.service10.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Categorie {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCategorie;
    private String nomCategorie;
    @OneToMany(mappedBy = "categorieProduct")
    private List<Product> Products;

    @Override
    public String toString() {
        return "Categorie{" +
                "idCategorie=" + idCategorie +
                ", nomCategorie='" + nomCategorie + '\'' +
                ", Products=" + Products +
                '}';
    }

    public Categorie(String nomCategorie) {
        this.nomCategorie = nomCategorie;
    }

    public Long getIdCategorie() {
        return idCategorie;
    }

    public void setIdCategorie(Long idCategorie) {
        this.idCategorie = idCategorie;
    }

    public String getNomCategorie() {
        return nomCategorie;
    }

    public void setNomCategorie(String nomCategorie) {
        this.nomCategorie = nomCategorie;
    }

    public List<Product> getProducts() {
        return Products;
    }

    public void setProducts(List<Product> Products) {
        this.Products = Products;
    }
}
