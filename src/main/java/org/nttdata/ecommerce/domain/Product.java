package org.nttdata.ecommerce.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.apache.commons.lang3.StringUtils;

import java.text.DecimalFormat;

@Getter
@Setter
@AllArgsConstructor
@Entity
@NoArgsConstructor
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",nullable = false)
    private Long id;

    private String name;

    private double price;


    public Product(String name, double price) {
        this.name = nameValidation(name);
        this.price = priceValidation(price);
    }

    public String nameValidation(String name) {
        if (name == null || name.isBlank())
            throw new IllegalArgumentException("The name cannot be empty");

        if(name.length() <2 || name.length()>51)
            throw new IllegalArgumentException("The name is 2smol or 2 big");
        return name;
    }

    public double priceValidation(double price){
        if(price<=0)
            throw new IllegalArgumentException("The price cannot be 0 or less");

        return (double) Math.round(price * 100) / 100;

    }



}

