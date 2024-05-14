package com.roshi.services;

import com.roshi.entities.RoshiResponse;
import com.roshi.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;


@Service
public class RoshiService {


//    public RoshiResponse getRoshiResponse() throws IOException {
//        String prompt = utils.getConsulKeyValue("http://localhost:8500/v1/kv/prompts/fighterz_translate_prompt");
//        String apiKey = utils.getConsulKeyValue("http://localhost:8500/v1/kv/openai/api_key");
//
//        String apiUrl = "https://api.openai.com/v1/chat/completions";
//
//        HttpHeaders headers = new HttpHeaders();
//        headers.setContentType(MediaType.APPLICATION_JSON);
//        headers.set("Authorization", "Bearer " + apiKey);
//
//        String requestBody = "{\"prompt\": \"" + prompt + "\", \"max_tokens\": 150}";
//
//        RestTemplate restTemplate = new RestTemplate();
//
//        HttpEntity<String> entity = new HttpEntity<>(requestBody, headers);
//
//        // Enviar a solicitação POST para a API do ChatGPT
//        ResponseEntity<String> response = restTemplate.postForEntity(apiUrl, entity, String.class);
//
//        // Retornar a resposta da API do ChatGPT
//        return response;
//
//
//
//
//    }
}
