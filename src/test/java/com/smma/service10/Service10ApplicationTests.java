package com.smma.service10;

import com.smma.service10.entities.Categorie;
import com.smma.service10.entities.Product;
import com.smma.service10.repositories.CategorieRepository;
import com.smma.service10.repositories.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.NoSuchElementException;

@SpringBootTest
class Service10ApplicationTests {

	@Autowired
	CategorieRepository categorieRepository;

	@Autowired
	ProductRepository serviceRepository;

	// Declare class variables for Categorie and Service
	private Categorie instagram;
	private Product instagramFollowers;

	@Test
	public void TestCreateCategorie(){
		// Create the Categorie and assign it to the class variable
		instagram = new Categorie("Instagram");
		// Save the Categorie if needed
		categorieRepository.save(instagram);
	}

	@Test
	public void TestCreateService(){
		instagramFollowers = new Product("Instagram followers", "Instant Start\nNon Drop\n1k = 1$", 1.00, instagram);
		serviceRepository.save(instagramFollowers);
	}

	@Test
	public void TestUpdateService(){
		try {
			Product service = serviceRepository.findById(1L).get();
			service.setDescriptionProduct("Instant Start\nNon Drop\n1k = 1.50$");
			service.setPrixProduct(1.50);
			serviceRepository.save(service);
		} catch (NoSuchElementException e) {
			System.out.println("Service not found");
		}
	}

	@Test
	public void TestFindServiceById(){
		try {
			Product service = serviceRepository.findById(1L).get();
			System.out.println(service);
		} catch (NoSuchElementException e) {
			System.out.println("Service not found");
		}
	}

	@Test
	public void TestFindAllService(){
		List<Product> services=serviceRepository.findAll();
		for (Product s : services){
			System.out.println(s);
		}
		services.forEach(System.out::println);
	}
	@Test
	public void TestDeleteServiceById(){
		serviceRepository.deleteById(1L);
	}
	@Test
	public void TestDeleteAllService(){
		serviceRepository.deleteAll();
	}
}
