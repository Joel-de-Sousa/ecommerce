package org.nttdata.ecommerce.service;



import org.modelmapper.ModelMapper;
import org.nttdata.ecommerce.domain.Product;
import org.nttdata.ecommerce.domain.factory.IProductFactory;
import org.nttdata.ecommerce.dto.ProductDTO;
import org.nttdata.ecommerce.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.stream.Collectors;


@Service
public class ProductService {

    @Autowired
    private IProductRepository iProductRepository;
    @Autowired
    private IProductFactory iProductFactory;
    @Autowired
    private ModelMapper mapper;

    public ProductDTO saveProduct(String name, double price) {
            Product product1 = iProductFactory.createProduct(name,price);
            Product pSave = iProductRepository.save(product1);
            return mapper.map(pSave, ProductDTO.class);
    }

    public List<ProductDTO> listAll() {
        List<Product> products = iProductRepository.findAll();
        return products.stream().map(product -> mapper.map(product, ProductDTO.class)).collect(Collectors.toList());
    }

    public ProductDTO findById(Long id) {
        Product product = iProductRepository.findById(id).get();
        return mapper.map(product, ProductDTO.class);
    }

    public void deleteById(Long id) {
        iProductRepository.deleteById(id);
    }

}
