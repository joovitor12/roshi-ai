package com.roshi.services;

import com.roshi.config.ConsulConfig;
import com.roshi.entities.Fighter;
import com.roshi.repositories.FightersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FighterService {

    @Autowired
    FightersRepository repository;

    public List<Fighter> getAllCharacters() {
        return repository.findAll();
    }

}
