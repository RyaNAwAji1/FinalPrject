package com.example.demo.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull(message = "Most Be Write ID Product !")
    private Integer id;
    @NotEmpty(message = "Most Be Write Product Name !")
    private String productName;
    @NotEmpty(message = "Most Be Write Product Type !")
    private String productType;


    // The RelationShip Between Product and Others ...

    @ManyToOne
    private Company company;
}
