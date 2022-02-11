package com.toker.alpbugra.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String brandName;
    private int price;
    //cascade type ; ensures that related classes are affected or unaffected by each other
    //so if i remove a product object and cascade type all or remove, it removes related category as well
    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn
    private Category category;

    public Product(String name, String brandName, int price, Category category) {
        this.name = name;
        this.brandName = brandName;
        this.price = price;
        this.category = category;
    }
}
