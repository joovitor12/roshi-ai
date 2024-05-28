package com.roshi.services;

import com.roshi.entities.Fighter;
import com.roshi.repositories.FighterzRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

@Service
public class FighterService {

    private Logger logger = Logger.getLogger(FighterService.class.getName());

    @Autowired
    FighterzRepository repository;

    public List<Fighter> getAll() {
        logger.info("Getting all Fighterz!");
        return repository.findAll();
    }

    public Fighter save (Fighter fighter) {
        logger.info("Saving a Fighter!");
        return repository.save(fighter);
    }

    public Fighter getById(String id) {
        logger.info("Getting a Fighter by id!");
        return repository.findById(id).orElse(null);
    }

}
