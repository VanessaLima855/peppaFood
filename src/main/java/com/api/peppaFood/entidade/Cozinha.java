package com.api.peppaFood.entidade;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.io.Serializable;


@Setter
@Getter
@Entity
@Table(name = "cozinha")
public class Cozinha implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nome;


}
