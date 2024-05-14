package com.roshi.utils;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.util.Base64;

public class Utils {

    public String getConsulKeyValue(String url) throws IOException {

        HttpClient httpClient = HttpClientBuilder.create().build();
        HttpGet request = new HttpGet(url);


        HttpResponse response = httpClient.execute(request);
        String responseBody = EntityUtils.toString((response.getEntity()));

        JSONArray jsonArray = new JSONArray(responseBody);
        JSONObject jsonObject = jsonArray.getJSONObject(0);

        String base64EncodedPrompt = jsonObject.getString("Value");

        byte[] decodedBytes = Base64.getDecoder().decode(base64EncodedPrompt);

        String keyValue = new String(decodedBytes);

        return keyValue;
    }
}
