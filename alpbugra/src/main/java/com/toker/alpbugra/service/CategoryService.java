package com.toker.alpbugra.service;


import com.toker.alpbugra.dto.CategoryDto;
import com.toker.alpbugra.dto.converter.CategoryDtoConverter;
import com.toker.alpbugra.dto.request.CategoryRequest;
import com.toker.alpbugra.model.Category;
import com.toker.alpbugra.repository.CategoryRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryService {


    private final CategoryRepository categoryRepository;
    private final ModelMapper modelMapper;

    public CategoryService(CategoryRepository categoryRepository, ModelMapper modelMapper) {
        this.categoryRepository = categoryRepository;
        this.modelMapper = modelMapper;
    }

    public CategoryDto findByCategoryName(Category category) {

        Category cat = categoryRepository.findByName(category.getName());

        return modelMapper.map(cat, CategoryDto.class);

    }

    public Category findByCategoryName(String categoryName) {

        return categoryRepository.findByName(categoryName);

    }

    public CategoryDto saveCategory(CategoryRequest categoryRequest) {

        Category c = new Category(categoryRequest.getName());

        return CategoryDtoConverter.convertToCategoryDto(categoryRepository.save(c));

    }

    public List<CategoryDto> getAllCategories() {


        return categoryRepository.findAll().stream().map(CategoryDtoConverter::convertToCategoryDto).collect(Collectors.toList());
    }
}
