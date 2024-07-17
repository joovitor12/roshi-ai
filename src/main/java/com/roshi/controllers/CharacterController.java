package com.roshi.controllers;

import com.roshi.entities.Fighter;
import com.roshi.services.FighterService;
import io.swagger.v3.oas.annotations.Operation;
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
    @Operation(summary = "Get all Fighterz saved on database.")
    public ResponseEntity<List<Fighter>> findAll(){
        return ResponseEntity.ok().body(service.getAll());
    }

    @PostMapping(value = "/save")
    @Operation(summary = "Save a Fighter")
    public ResponseEntity<Fighter> save(@RequestBody Fighter fighter){
        return ResponseEntity.ok().body(service.save(fighter));
    }

    @GetMapping(value = "/{id}")
    @Operation(summary = "Find a Fighter by ID")
    public ResponseEntity<Fighter> findById(@PathVariable String id){
        return ResponseEntity.ok().body(service.getById(id));
    }
}
