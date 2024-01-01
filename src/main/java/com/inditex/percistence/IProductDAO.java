package com.inditex.percistence;

import com.inditex.percistence.entities.Product;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface IProductDAO {

    Optional<Product> findById(Long id);

    List<Product> findAll();

    List<Product> findByPriceInRange(BigDecimal min, BigDecimal max);

    void save(Product product);

    void deleteById(Long id);
}
