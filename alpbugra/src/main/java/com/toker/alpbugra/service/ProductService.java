package com.toker.alpbugra.service;

import com.toker.alpbugra.dto.ProductDto;
import com.toker.alpbugra.dto.converter.ProductDtoConverter;
import com.toker.alpbugra.dto.request.ProductRequest;
import com.toker.alpbugra.model.Product;
import com.toker.alpbugra.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ProductService {


    private final ProductRepository productRepository;
    private final ModelMapper modelMapper;
    private final CategoryService categoryService;


    public ProductDto saveProduct(ProductRequest productRequest){

        Product p = new Product(productRequest.getName(),
                productRequest.getBrandName(),
                productRequest.getPrice(),
                categoryService.findByCategoryName(productRequest.getCategoryName()));

        /*
        Product product = modelMapper.map(productRequest, Product.class);
        modelMapper.typeMap(ProductRequest.class, Product.class).addMappings(mapper -> {
            mapper.map(src -> categoryService.findByCategoryName(src.getCategoryName()),
                    Product::setCategory);
            mapper.map(src -> src.getBillingAddress().getCity(),
                    Product::setBillingCity);
        });
        ProductDto productDto = modelMapper.map(productRequest, ProductDto.class);
        productRepository.save(product);
        */

        return ProductDtoConverter.convertToProductDto(productRepository.save(p));
    }
    public List<ProductDto> getAllProducts(){

        return productRepository.findAll()
                .stream()
                .map(ProductDtoConverter::convertToProductDto).collect(Collectors.toList());
    }
}
