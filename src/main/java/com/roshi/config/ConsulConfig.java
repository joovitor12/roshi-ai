package com.roshi.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

@Component
@RefreshScope
public class ConsulConfig {

    @Value("${insight-prompt}")
    private String fighterzInsightPrompt;

    @Value("${translate-prompt}")
    private String fighterzTranslatePrompt;

    @Value("${team-prompt}")
    private String teamPrompt;

    public String getFighterzTranslatePrompt(){
        return fighterzTranslatePrompt;
    }

    public String getFighterzInsightPrompt(){
        return fighterzInsightPrompt;
    }

    public String getTeamPrompt(){
        return teamPrompt;
    }


}
