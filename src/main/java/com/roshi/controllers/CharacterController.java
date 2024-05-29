package com.roshi.controllers;

import com.roshi.entities.Fighter;
import com.roshi.services.FighterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/fighterz/v1")
public class CharacterController {

    @Autowired
    FighterService service;

    @GetMapping(value = "/")
    public ResponseEntity<List<Fighter>> findAll(){
        return ResponseEntity.ok().body(service.getAll());
    }

    @PostMapping(value = "/save")
    public ResponseEntity<Fighter> save(@RequestBody Fighter fighter){
        return ResponseEntity.ok().body(service.save(fighter));
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Fighter> findById(@PathVariable String id){
        return ResponseEntity.ok().body(service.getById(id));
    }
}
