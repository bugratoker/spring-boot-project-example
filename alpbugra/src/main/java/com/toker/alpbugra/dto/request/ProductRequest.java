package com.toker.alpbugra.dto.request;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductRequest {

    private String name;
    private String brandName;
    private int price;
    private String categoryName;

}