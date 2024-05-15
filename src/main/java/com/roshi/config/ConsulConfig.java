package com.roshi.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

@Component
@RefreshScope
public class ConsulConfig {

    @Value("${api-key}")
    private String apiKey;

    @Value("${prompt}")
    private String fighterzTranslatePrompt;

    public String getApiKey(){
        return apiKey;
    }

    public String getFighterzTranslatePrompt(){
        return fighterzTranslatePrompt;
    }


}
