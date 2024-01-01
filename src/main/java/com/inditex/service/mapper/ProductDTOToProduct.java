package com.inditex.service.mapper;

import com.inditex.percistence.entities.Product;
import com.inditex.service.dto.ProductDTO;
import org.springframework.stereotype.Component;

@Component
public class ProductDTOToProduct implements IMapper<ProductDTO, Product>{
    @Override
    public Product map(ProductDTO in) {
        Product product = new Product();
        product.setId(in.getId());
        product.setName(in.getName());
        product.setPrice(in.getPrice());
        product.setMaker(in.getMaker());
        return product;
    }

    @Override
    public Product mapExist(ProductDTO in, Product inExist) {
        inExist.setId(in.getId());
        inExist.setName(in.getName());
        inExist.setPrice(in.getPrice());
        inExist.setMaker(in.getMaker());
        return inExist;
    }
}
