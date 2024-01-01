package com.inditex.controllers;

import com.inditex.service.dto.ProductDTO;
import com.inditex.percistence.entities.Product;
import com.inditex.service.IProductService;
import com.inditex.service.mapper.ProductDTOToProduct;
import com.inditex.service.mapper.ProductToProductDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/product")
public class ProductController {

    @Autowired
    private IProductService productService;
    @Autowired
    private ProductDTOToProduct productDTOToProduct;
    @Autowired
    private ProductToProductDTO productToProductDTO;

@GetMapping("find/{id}")
public ResponseEntity<?> findById(@PathVariable Long id){
    Optional<Product> productOptional = productService.findById(id);

    if(productOptional.isPresent()){
        Product product = productOptional.get();
        ProductDTO productDTO = productToProductDTO.map(product);

        return ResponseEntity.ok(productDTO);
    }
    return ResponseEntity.notFound().build();
}

@GetMapping("/findAll")
public ResponseEntity<?> findAll(){
    List<ProductDTO> productDTOList = productService.findAll()
            .stream()
            .map(product -> productToProductDTO.map(product))
            .toList();
    return ResponseEntity.ok(productDTOList);
}

@PostMapping("/save")
public ResponseEntity<?> save(@RequestBody ProductDTO productDTO) throws URISyntaxException {
    if(productDTO.getName().isBlank() || productDTO.getPrice() == null || productDTO.getMaker() == null){
        return ResponseEntity.badRequest().build();
    }

    productService.save(productDTOToProduct.map(productDTO));

    return ResponseEntity.created(new URI("/api/product/save")).build();
}

@PutMapping("/update/{id}")
public ResponseEntity<?> update(@PathVariable Long id, @RequestBody ProductDTO productDTO){
    Optional<Product> optionalProduct = productService.findById(id);

    if(optionalProduct.isPresent()){
        Product product = optionalProduct.get();
        productDTO.setId(product.getId());
        productDTO.setMaker(product.getMaker());
        productService.save(productDTOToProduct.mapExist(productDTO,product));

        return ResponseEntity.ok("Registro actualizado");
    }

    return ResponseEntity.notFound().build();
}

@DeleteMapping("/delete/{id}")
public ResponseEntity<?> delete(@PathVariable Long id){
    if(id != null){
        productService.deleteById(id);
        return ResponseEntity.ok("Registro eliminado");
    }

    return ResponseEntity.notFound().build();

}

@GetMapping("/findByRange/{min}/{max}")
public ResponseEntity<?> findByRange(@PathVariable BigDecimal min, @PathVariable BigDecimal max){
    if(min == null || max == null){
        return ResponseEntity.badRequest().build();
    }
    List<ProductDTO> productDTOList = productService.findByPriceInRange(min, max)
            .stream()
            .map(product -> productToProductDTO.map(product))
            .toList();
    return ResponseEntity.ok(productDTOList);
}

}
