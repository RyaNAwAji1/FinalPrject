package com.example.demo.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class ServiceEvaluation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull(message = "Most Be Write ID Service Evaluation !")
    private Integer id;
    @NotEmpty(message = "Write a Message For The Service !")
    private String message;


    // The RelationShip Between ServiceEvaluation and Others ...

    @OneToOne(cascade = CascadeType.ALL)
    @MapsId
    private User user;
}
