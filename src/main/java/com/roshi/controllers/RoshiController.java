package com.roshi.controllers;

import com.roshi.utils.Utils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;
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


@RequestMapping("/api/roshi")
public class RoshiController {

    Utils utils = new Utils();

    @GetMapping(value = "/insight", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> getInsight(){
        return ResponseEntity.ok().body("definitive insight");
    }

    @GetMapping(value = "/prompt", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> getTranslatePrompt() throws IOException{
        //  RESPONSE
        // {
        //    "error": {
        //        "message": "You exceeded your current quota, please check your plan and billing details. For more information on this error, read the docs: https://platform.openai.com/docs/guides/error-codes/api-errors.",
        //        "type": "insufficient_quota",
        //        "param": null,
        //        "code": "insufficient_quota"
        //    }
        //}
        String apiUrl = "https://api.openai.com/v1/chat/completions";
        String apiKey = utils.getConsulKeyValue("http://localhost:8500/v1/kv/openai/api_key");

        String requestBody = utils.getConsulKeyValue("http://localhost:8500/v1/kv/prompts/fighterz_translate_prompt");

        HttpClient httpClient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(apiUrl);

        httpPost.addHeader("Content-Type", "application/json");
        httpPost.addHeader("Authorization", "Bearer " + apiKey);

        StringEntity stringEntity = new StringEntity(requestBody);
        httpPost.setEntity(stringEntity);

        HttpResponse httpResponse = httpClient.execute(httpPost);

        HttpEntity httpEntity = httpResponse.getEntity();
        String response = EntityUtils.toString(httpEntity);

        return ResponseEntity.ok().body(response);

    }


}
