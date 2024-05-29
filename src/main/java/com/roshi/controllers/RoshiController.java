package com.roshi.controllers;

import com.roshi.services.RoshiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/roshi")
public class RoshiController {

    @Autowired
    RoshiService service;

    @GetMapping(value = "/translate", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> getTranslatePrompt(@RequestParam(value = "sequence",
            defaultValue = "2M > 5M > j.MLL > j.2H > SD > j.MLL > j.2H > dj.LLL") String sequence) {
        return ResponseEntity.ok().body(service.getRoshiTranslatorResponse(sequence));
    }

    @GetMapping(value = "/insight", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> getInsight(@RequestParam(value = "question",
            defaultValue = "How do i counter a mixup?") String question) {
        return ResponseEntity.ok().body(service.getRoshiInsight(question));
    }

    @GetMapping(value = "/team", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> getTeam(@RequestParam(value = "question",
            defaultValue = "Do you know any good team composition?") String question) {
        return ResponseEntity.ok().body(service.getRoshiTeamComposition(question));
    }

}
