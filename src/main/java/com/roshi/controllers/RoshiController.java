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

    @GetMapping(value = "/prompt", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> getTranslatePrompt(@RequestParam(value = "sequence",
            defaultValue = "2M > 5M > j.MLL > j.2H > SD > j.MLL > j.2H > dj.LLL") String sequence) {
        return ResponseEntity.ok().body(service.getRoshiTranslatorResponse(sequence));
    }

}
