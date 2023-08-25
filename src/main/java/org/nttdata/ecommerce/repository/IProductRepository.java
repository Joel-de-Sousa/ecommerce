package org.nttdata.ecommerce.repository;

import org.nttdata.ecommerce.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProductRepository  extends JpaRepository<Product,Long> {

    Product findByName(String name);
    boolean existsByName(String name);
}
