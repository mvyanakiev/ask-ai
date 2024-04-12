package org.example.askai.controller;

import org.example.askai.model.AskModel;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AskController {

    @PostMapping("/ask")
    public String askAi(@RequestBody AskModel askModel) {

        String question = askModel.getQuestion();
        String scenario = askModel.getScenario();
        return question + " " + scenario;
    }


}
