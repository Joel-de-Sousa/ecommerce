package org.nttdata.ecommerce;

import org.nttdata.ecommerce.controller.ProductController;
import org.nttdata.ecommerce.domain.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class EcommerceApplication {

	@Autowired
	ProductController productController ;



	public static void main(String[] args) {

		Product p1 = new Product(1L,"chocolate",10);


		SpringApplication.run(EcommerceApplication.class, args);


	}
	@Bean
	public CommandLineRunner add10(){

		return (args) -> {

		Product p1 = new Product(1L,"chocolate",10.5);
		Product p2 = new Product(2L,"apple",2.2);
		Product p3 = new Product(3L,"yogurt",5.1);
		Product p4 = new Product(4L,"apple pie",6.3);
		Product p5 = new Product(5L,"coca cola",6.1);
		Product p6 = new Product(6L,"ham",10.54);
		Product p7 = new Product(7L,"cheese",3.45);
		Product p8 = new Product(8L,"carrots",61.4);
		Product p9 = new Product(9L,"po-ta-toes",66.6);
		Product p10 = new Product(10L,"banana",2.45);
		productController.saveProduct(p1);
		productController.saveProduct(p2);
		productController.saveProduct(p3);
		productController.saveProduct(p4);
		productController.saveProduct(p5);
		productController.saveProduct(p6);
		productController.saveProduct(p7);
		productController.saveProduct(p8);
		productController.saveProduct(p9);
		productController.saveProduct(p10);
			System.out.println("Products added successfully");

	};
}
}
