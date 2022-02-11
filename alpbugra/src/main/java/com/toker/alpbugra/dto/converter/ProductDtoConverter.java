package com.toker.alpbugra.dto.converter;

import com.toker.alpbugra.dto.ProductDto;
import com.toker.alpbugra.dto.request.ProductRequest;
import com.toker.alpbugra.model.Product;
import com.toker.alpbugra.service.CategoryService;

public class ProductDtoConverter {


    public static ProductDto convertToProductDto(Product p){


        return ProductDto.builder()
                .brandName(p.getBrandName())
                .category(CategoryDtoConverter.convertToProductCategoryDto(p.getCategory()))
                .name(p.getName())
                .price(p.getPrice())
                .build();

    }


}
