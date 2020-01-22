package com.mercadao.productservice.repository;

import com.mercadao.productservice.domain.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Integer> {

    Product findByProductId(Integer productId);

}
