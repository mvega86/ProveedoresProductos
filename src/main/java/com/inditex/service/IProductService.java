package com.inditex.service;

import com.inditex.entities.Product;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface IProductService {

    Optional<Product> findById(Long id);

    List<Product> findAll();

    List<Product> findByPriceInRange(BigDecimal min, BigDecimal max);

    void save(Product product);

    void deleteById(Long id);
}
