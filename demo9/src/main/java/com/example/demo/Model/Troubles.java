package com.example.demo.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Troubles {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer troubleID;
    @NotEmpty(message = "Most Be Write The Trouble Type !")
    private String troubleType;
    @NotEmpty(message = "Most Be Write a Location !")
    private String location;



    // The RelationShip Between Troubles and Others ...

    @ManyToOne
    private User users;

    @ManyToOne
    @JsonIgnore
    private Company company;
}
