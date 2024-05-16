package com.roshi.controllers;

import com.roshi.entities.Fighter;
import com.roshi.services.FighterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/character")
public class CharacterController {

    @Autowired
    FighterService service;

    @GetMapping(value = "/all")
    public ResponseEntity<List<Fighter>> findAll(){
        return ResponseEntity.ok().body(service.getAllCharacters());
    }
}
