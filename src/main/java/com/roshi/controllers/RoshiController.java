package com.roshi.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.roshi.config.ConsulConfig;
import com.roshi.config.PromptConfig;
import com.roshi.entities.RoshiResponse;
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
    ConsulConfig config;

    private final ChatClient chatClient;


    public RoshiController(ChatClient chatClient) {
        this.chatClient = chatClient;
    }

    @GetMapping(value = "/prompt", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<RoshiResponse> getTranslatePrompt(@RequestParam(value = "sequence", defaultValue = "2M > 5M > j.MLL > j.2H > SD > j.MLL > j.2H > dj.LLL") String sequence) throws JsonProcessingException {
        String json = config.getFighterzTranslatePrompt();
        ObjectMapper mapper = new ObjectMapper();
        PromptConfig promptConfig = mapper.readValue(json, PromptConfig.class);


        var system = new SystemMessage(promptConfig.getPrompt());
        var user = new UserMessage(sequence);

        Prompt prompt = new Prompt(List.of(system,user));

        RoshiResponse response= new RoshiResponse(chatClient.call(prompt).getResult().getOutput().getContent());

        return ResponseEntity.ok().body(response);



    }

}
