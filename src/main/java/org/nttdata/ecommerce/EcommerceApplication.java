package org.nttdata.ecommerce;

import org.modelmapper.ModelMapper;
import org.nttdata.ecommerce.controller.ProductController;
import org.nttdata.ecommerce.domain.Product;
import org.nttdata.ecommerce.dto.ProductDTO;
import org.nttdata.ecommerce.dto.mapper.Mapper;
import org.nttdata.ecommerce.repository.IProductRepository;
import org.nttdata.ecommerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class EcommerceApplication {

    @Autowired
    IProductRepository iProductRepository;
    ;


    public static void main(String[] args) {

        Product p1 = new Product(1L, "chocolate", 10);


        SpringApplication.run(EcommerceApplication.class, args);


    }

    @Bean
    public CommandLineRunner addProducts(ProductService productService) {

        return (args) -> {
            for (int i = 1; i <= 10; i++) {
                String productName = "Product " + i;
                double productPrice = 10.0 * i; // Just an example price calculation

                ProductDTO productDTO = new ProductDTO();
                productDTO.setName(productName);
                productDTO.setPrice(productPrice);

                productService.saveProduct(productDTO.getName(), productDTO.getPrice());

            }
            System.out.println("Products added successfully");
        };
    }
}
