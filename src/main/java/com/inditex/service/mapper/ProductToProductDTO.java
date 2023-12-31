package com.inditex.service.mapper;

import com.inditex.percistence.entities.Product;
import com.inditex.service.dto.ProductDTO;
import org.springframework.stereotype.Component;

@Component
public class ProductToProductDTO implements IMapper<Product, ProductDTO>{
    @Override
    public ProductDTO map(Product in) {
        ProductDTO productDTO = new ProductDTO();
        productDTO.setId(in.getId());
        productDTO.setName(in.getName());
        productDTO.setPrice(in.getPrice());
        productDTO.setMaker(in.getMaker());
        return productDTO;
    }

    @Override
    public ProductDTO mapExist(Product in, ProductDTO inExist) {
        inExist.setId(in.getId());
        inExist.setName(in.getName());
        inExist.setPrice(in.getPrice());
        inExist.setMaker(in.getMaker());
        return inExist;
    }
}
