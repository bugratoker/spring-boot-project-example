package com.toker.alpbugra.controller;

import com.toker.alpbugra.dto.CategoryDto;
import com.toker.alpbugra.dto.request.CategoryRequest;
import com.toker.alpbugra.model.Category;
import com.toker.alpbugra.service.CategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/category/")
public class CategoryController {
    
    
    private final CategoryService categoryService;
    
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }
    
    
    @PostMapping("saveCategory")
    public ResponseEntity<CategoryDto> saveCategory(@RequestBody CategoryRequest categoryRequest){

        return new ResponseEntity<>( categoryService.saveCategory(categoryRequest),HttpStatus.CREATED);

    }
    @GetMapping("getAllCategories")
    public ResponseEntity<List<CategoryDto>> getAllCategories(){

        return new ResponseEntity<>(categoryService.getAllCategories(),HttpStatus.OK);
    }
    
}
