package com.api.peppaFood.service;

import com.api.peppaFood.entidade.Cozinha;
import com.api.peppaFood.repository.CozinhaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;


@Service
public class CozinhaService {

    final CozinhaRepository cozinhaRepository;

    public CozinhaService(CozinhaRepository cozinhaRepository) {
        this.cozinhaRepository = cozinhaRepository;
    }

    public List<Cozinha> listarCozinhas(){
        return cozinhaRepository.findAll();
    }

    @Transactional
    public Cozinha salvarCozinha(Cozinha cozinha){
        return cozinhaRepository.save(cozinha);
    }

    public Optional<Cozinha> findById(Long id) {
        return cozinhaRepository.findById(id);
    }

    @Transactional
    public void deleteById(Long id){
         cozinhaRepository.deleteById(id);
    }


}
