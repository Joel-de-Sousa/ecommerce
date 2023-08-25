package org.nttdata.ecommerce.controller;

import org.nttdata.ecommerce.domain.Product;
import org.nttdata.ecommerce.repository.IProductRepository;
import org.nttdata.ecommerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RestController
@RequestMapping(path = "/products")
public class ProductController {

    @Autowired
    private ProductService productService;
    @Autowired
    private IProductRepository iProductRepository;


    @ResponseBody
    @GetMapping
    public ResponseEntity<Object> getAllProducts(){
        List<Product> listProducts = productService.listAll();

            return new ResponseEntity<>(listProducts, HttpStatus.OK);

    }

    @ResponseBody
    @GetMapping("/{id}")
    public ResponseEntity<Object> getProductById(@PathVariable Long id){
        Product product =  productService.findById(id);

        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<Object> saveProduct(@RequestBody Product product){
        try {
            Product saveProduct = productService.saveProduct(product);
            if (saveProduct != null)
                return new ResponseEntity<>(saveProduct, HttpStatus.OK);
            else throw new Exception();
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }

    @ResponseBody
    @DeleteMapping("/{id}")
    public void deleteProductById(@PathVariable Long id){
        productService.deleteById(id);
    }
}



