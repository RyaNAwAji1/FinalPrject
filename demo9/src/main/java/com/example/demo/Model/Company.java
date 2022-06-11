package com.example.demo.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @NotNull(message = "Most Write Price !")
    private Integer price;
    @NotEmpty(message = "Most Write Quality !")
    private String quality;

    // The RelationShip Between Company and Others ...

    @OneToMany(cascade = CascadeType.ALL)
    private Set <Troubles> troubles;

    @OneToMany
    private Set <Product> products;

    @OneToMany(mappedBy = "company",cascade = CascadeType.ALL)
    @JsonIgnore
    private Set <Invoice> invoices;
}
