package com.inditex.repository;

import com.inditex.entities.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {

    @Query("select p from Product p WHERE p.price BETWEEN ?1 AND ?2")
    List<Product> findProductByPriceInRange(BigDecimal minPrice, BigDecimal maxPrice);
    List<Product> findProductByPriceBetween(BigDecimal minPrice, BigDecimal maxPrice);


}
