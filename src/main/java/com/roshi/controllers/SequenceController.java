package com.roshi.controllers;

import com.roshi.entities.Sequence;
import com.roshi.services.SequenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sequence/v1")
public class SequenceController {

    @Autowired
    SequenceService service;

    @PostMapping(value = "/save")
    public ResponseEntity<Sequence> save(@RequestBody Sequence sequence, @RequestParam String id){
        return ResponseEntity.ok().body(service.save(sequence, id));
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<List<Sequence>> getSequences(@PathVariable String id){
        return ResponseEntity.ok().body(service.getSequences(id));
    }
}
