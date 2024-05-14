package com.roshi.controllers;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.IOException;
import java.util.Base64;

@RestController
@RequestMapping("/api/roshi")
public class RoshiController {

    @GetMapping(value = "/insight", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> getInsight(){
        return ResponseEntity.ok().body("definitive insight");
    }

    @GetMapping(value = "/prompt", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> getTranslatePrompt() throws IOException{
        String consulUrl = "http://localhost:8500/v1/kv/prompts/fighterz_translate_prompt";

        HttpClient httpClient = HttpClientBuilder.create().build();
        HttpGet request = new HttpGet(consulUrl);


        HttpResponse response = httpClient.execute(request);
        String responseBody = EntityUtils.toString((response.getEntity()));

        JSONArray jsonArray = new JSONArray(responseBody);
        JSONObject jsonObject = jsonArray.getJSONObject(0);

        String base64EncodedPrompt = jsonObject.getString("Value");

        byte[] decodedBytes = Base64.getDecoder().decode(base64EncodedPrompt);

        String prompt = new String(decodedBytes);

        return ResponseEntity.ok().body(prompt);
    }
}
