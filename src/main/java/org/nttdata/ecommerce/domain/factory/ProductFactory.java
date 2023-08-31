package org.nttdata.ecommerce.domain.factory;

import org.nttdata.ecommerce.domain.Product;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class ProductFactory implements IProductFactory{

    @Override
    public Product createProduct(String name, double price){return (new Product(name,price));
    }
}
