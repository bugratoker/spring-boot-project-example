package com.toker.alpbugra.dto;


import com.toker.alpbugra.model.Category;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Component
@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class ProductDto {

    private String name;
    private String brandName;
    private int price;

    private ProductCategoryDto category;

}
