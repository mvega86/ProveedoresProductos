package com.inditex.controllers.dto;

import com.inditex.entities.Product;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MakerDTO {
    private Long id;
    private String name;
    private List<Product> productList = new ArrayList<>();
}
