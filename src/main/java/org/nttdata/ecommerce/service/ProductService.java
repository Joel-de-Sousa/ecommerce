package org.nttdata.ecommerce.service;

import jakarta.validation.ConstraintViolation;
import org.nttdata.ecommerce.domain.Product;
import org.nttdata.ecommerce.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.validation.Validator;
import java.util.List;
import java.util.Set;

@Service
public class ProductService {

    @Autowired
    private IProductRepository iProductRepository;

    public Product saveProduct(Product product) {
        try{
            Product product1 = new Product(product.getName(), product.getPrice());
            boolean exists = iProductRepository.existsByName(product.getName());
        if(!exists){
            return iProductRepository.save(product1);
        }
            else {
            throw new Exception("The Product already exists!");
        }
    } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public List<Product> listAll() {
        return iProductRepository.findAll();
    }

    public Product findById(Long id) {
        return iProductRepository.findById(id).get();
    }

    public void deleteById(Long id) {
        iProductRepository.deleteById(id);
    }
}
