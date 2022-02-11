package com.toker.alpbugra.controller;

import com.toker.alpbugra.dto.ProductDto;
import com.toker.alpbugra.dto.request.ProductRequest;
import com.toker.alpbugra.model.Product;
import com.toker.alpbugra.service.ProductService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/product/")
@AllArgsConstructor
public class ProductController {


    private final ProductService productService;



    @PostMapping("save")
    public ResponseEntity<ProductDto> saveProduct(@RequestBody ProductRequest productRequest){


        return new  ResponseEntity<>(productService.saveProduct(productRequest), HttpStatus.OK);
    }
    @GetMapping("getAll")
    public ResponseEntity<List<ProductDto>> getAllProducts(){


        return new ResponseEntity<>(productService.getAllProducts(),HttpStatus.FOUND);
    }

}
