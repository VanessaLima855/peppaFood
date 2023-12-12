package com.api.peppaFood.controller;

import com.api.peppaFood.dtos.CozinhaDto;
import com.api.peppaFood.entidade.Cozinha;
import com.api.peppaFood.service.CozinhaService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cozinha")
public class CozinhaController {
    final CozinhaService cozinhaService;

    public CozinhaController(CozinhaService cozinhaService) {
        this.cozinhaService = cozinhaService;
    }
    @GetMapping("/listar-cozinhas")
    @ResponseStatus(HttpStatus.OK)
    public List<Cozinha> listarCozinhas(){
        return cozinhaService.listarCozinhas();
    }

    @PostMapping("/salvar-cozinha")
    public ResponseEntity<Cozinha> salvarCozinha(@RequestBody Cozinha cozinha){
       Cozinha cozinhaSalva = cozinhaService.salvarCozinha(cozinha);
       return ResponseEntity.status(HttpStatus.CREATED).body(cozinhaSalva);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> atualizarCozinha(@PathVariable Long id,
                                                   @RequestBody @Valid CozinhaDto cozinhaDto){
        Optional<Cozinha> cozinhaOptional = cozinhaService.findById(id);
            if((!cozinhaOptional.isPresent())){
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cozinha not found");
            }
        var cozinha = new Cozinha();
        BeanUtils.copyProperties(cozinhaDto, cozinha);
        cozinha.setId(cozinhaOptional.get().getId());
        return ResponseEntity.status(HttpStatus.OK).body(cozinhaService.salvarCozinha(cozinha));
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity< Object> deletarCozinha(@PathVariable Long id){

        Optional<Cozinha> cozinhaOptional = cozinhaService.findById(id);
        if((!cozinhaOptional.isPresent())){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cozinha not found");
        }
        cozinhaService.deleteById(cozinhaOptional.get().getId());
        return ResponseEntity.noContent().build();


    }

}
