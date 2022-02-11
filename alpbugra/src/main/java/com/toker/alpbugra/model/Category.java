package com.toker.alpbugra.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Category {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name="UUID",strategy = "org.hibernate.id.UUIDGenerator")
    private String id;
    private String name;
    @OneToMany(mappedBy = "category",orphanRemoval = true,fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private List<Product> products;

    public Category(String name) {
        this.name = name;
        products = new ArrayList<Product>();
    }
}
