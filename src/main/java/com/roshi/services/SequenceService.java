package com.roshi.services;

import com.roshi.entities.Sequence;
import com.roshi.exceptions.ResourceNotFoundException;
import com.roshi.repositories.FighterzRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

@Service
public class SequenceService {

    Logger logger = Logger.getLogger(SequenceService.class.getName());

    @Autowired
    FighterzRepository repository;

    public Sequence save(Sequence sequence, String id) {
        logger.info("Saving a Sequence for id " + id);

        var fighter = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));

        fighter.getSequences().add(sequence);

        repository.save(fighter);

        return sequence;
    }

    public List<Sequence> getSequences(String id) {
        logger.info("Getting all Sequences for id " + id);

        var entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));

        return entity.getSequences();
    }


}
