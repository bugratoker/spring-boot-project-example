package com.toker.alpbugra.dto;


import com.toker.alpbugra.model.Product;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CategoryDto {

    private String name;

    private List<ProductDto> products;



}
