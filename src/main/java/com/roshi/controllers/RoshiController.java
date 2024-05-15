package com.roshi.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.roshi.config.ConsulConfig;
import com.roshi.config.PromptConfig;
import com.roshi.entities.RoshiResponse;
import com.roshi.services.RoshiService;
import org.springframework.ai.chat.ChatClient;
import org.springframework.ai.chat.messages.SystemMessage;
import org.springframework.ai.chat.messages.UserMessage;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/roshi")
public class RoshiController {

    @Autowired
    RoshiService service;

    @GetMapping(value = "/prompt", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> getTranslatePrompt(@RequestParam(value = "sequence", defaultValue = "2M > 5M > j.MLL > j.2H > SD > j.MLL > j.2H > dj.LLL") String sequence) throws JsonProcessingException {
        return ResponseEntity.ok().body(service.getRoshiTranslatorResponse(sequence));
    }

}
