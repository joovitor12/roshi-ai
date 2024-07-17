package com.roshi.controllers;

import com.roshi.services.RoshiService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/roshi/v1")
public class RoshiController {

    @Autowired
    RoshiService service;

    @Operation(summary = "Translates a combo sequence",
            description = "Provide a combo sequence to get its translation, to get better accuracy in the translator, follow the default value format.")
    @GetMapping(value = "/translate", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> getTranslatePrompt(@RequestParam(value = "sequence",
            defaultValue = "2M > 5M > j.MLL > j.2H > SD > j.MLL > j.2H > dj.LLL") String sequence) {
        return ResponseEntity.ok().body(service.getRoshiTranslatorResponse(sequence));
    }

    @GetMapping(value = "/insight", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Get an insight from Roshi about game concepts.",
            description = """
                    Provides insight on a given question. Ask a question to receive insightful\s
                    responses about different game strategies and mechanics, such as mixups, neutral game,\s
                    and okizeme. For instance, you might ask, 'What is the best approach to maintain neutral?' or\s
                    'How can I optimize my okizeme tactics?
                   \s""")
    public ResponseEntity<String> getInsight(@RequestParam(value = "question",
            defaultValue = "How do i counter a mixup?") String question) {
        return ResponseEntity.ok().body(service.getRoshiInsight(question));
    }

    @GetMapping(value = "/team", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Get a team composition based on the Fighter question.",
            description = """
                   Provides team composition advice. Ask for team composition recommendations and\s
                   receive tailored suggestions to improve your gameplay. For example, you can inquire,\s
                   'Do you know team compositions using Base Goku as a anchor?' or 'What characters work well together for a balanced team?
                   \s""")
    public ResponseEntity<String> getTeam(@RequestParam(value = "question",
            defaultValue = "Do you know any good team composition?") String question) {
        return ResponseEntity.ok().body(service.getRoshiTeamComposition(question));
    }

}
