package org.nttdata.ecommerce.controller;

import org.modelmapper.ModelMapper;
import org.nttdata.ecommerce.dto.ProductDTO;
import org.nttdata.ecommerce.repository.IProductRepository;
import org.nttdata.ecommerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/products")
public class ProductController {

    @Autowired
    private ProductService productService;
    @Autowired
    private IProductRepository iProductRepository;
    @Autowired
    private ModelMapper modelMapper;


    @ResponseBody
    @GetMapping
    public ResponseEntity<Object> getAllProducts(){
        List<ProductDTO> listProducts = productService.listAll();

            return new ResponseEntity<>(listProducts, HttpStatus.OK);

    }

    @ResponseBody
    @GetMapping("/{id}")
    public ResponseEntity<Object> getProductById(@PathVariable Long id){
        ProductDTO product =  productService.findById(id);

        return new ResponseEntity<>(product, HttpStatus.OK);

    }

    @PostMapping("")
    public ResponseEntity<Object> saveProduct(@RequestBody ProductDTO productDTO){
        try {
            ProductDTO saveProduct = productService.saveProduct(productDTO.getName(), productDTO.getPrice());
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



