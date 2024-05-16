package com.roshi.repositories;

import com.roshi.entities.Fighter;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FightersRepository extends MongoRepository<Fighter, String> {

}
