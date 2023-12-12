package com.api.peppaFood.dtos;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CozinhaDto {

    @NotBlank
    private String nome;

}
