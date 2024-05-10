package com.roshi.controllers;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/roshi")
public class RoshiController {

    @GetMapping(value = "/insight", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> getInsight(){
        return ResponseEntity.ok().body("definitive insight");
    }
}
