package com.roshi.services;

import com.roshi.config.ConsulConfig;
import org.springframework.ai.chat.ChatClient;
import org.springframework.ai.chat.messages.SystemMessage;
import org.springframework.ai.chat.messages.UserMessage;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;


@Service
public class RoshiService {

    private Logger logger = Logger.getLogger(RoshiService.class.getName());

    @Autowired
    ConsulConfig consulConfig;

    private final ChatClient chatClient;

    public RoshiService(ChatClient chatClient) {
        this.chatClient = chatClient;
    }

    public String getRoshiTranslatorResponse(String sequence) {
        logger.info("Getting Roshi Translator Response");
        
        String translatePrompt = consulConfig.getFighterzTranslatePrompt();
        var system = new SystemMessage(translatePrompt);
        var user = new UserMessage(sequence);

        Prompt prompt = new Prompt(List.of(system,user));

        String response = chatClient.call(prompt).getResult().getOutput().getContent();

        return response;
    }


}
