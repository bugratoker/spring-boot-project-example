package com.toker.alpbugra.dto.converter;

import com.toker.alpbugra.dto.CategoryDto;
import com.toker.alpbugra.dto.ProductCategoryDto;
import com.toker.alpbugra.model.Category;

import java.util.stream.Collectors;

public class CategoryDtoConverter {

    public static CategoryDto convertToCategoryDto(Category c) {

        return CategoryDto.builder()
                .name(c.getName())
                .products(c.getProducts()
                        .stream()
                        .map(ProductDtoConverter::convertToProductDto)
                        .collect(Collectors.toList()))
                .build();
    }

    public static ProductCategoryDto convertToProductCategoryDto(Category c) {

        return ProductCategoryDto.builder().
                name(c.getName())
                .build();
    }

}

