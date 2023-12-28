package com.inditex.percistence;

import com.inditex.entities.Maker;
import com.inditex.entities.Product;

import java.util.List;
import java.util.Optional;

public interface IProductDAO {

    Optional<Product> findById(Long id);

    List<Product> findAll();

    void save(Product product);

    void deleteById(Long id);

    void update(Product product, Long id);
}
