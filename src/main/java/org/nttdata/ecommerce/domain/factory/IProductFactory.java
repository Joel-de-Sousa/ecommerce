package org.nttdata.ecommerce.domain.factory;

import org.nttdata.ecommerce.domain.Product;

public interface IProductFactory {

    Product createProduct(String name, double price);
}
