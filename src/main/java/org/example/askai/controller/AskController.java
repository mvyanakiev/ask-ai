package org.example.askai.controller;

import org.example.askai.model.AskModel;
import org.example.askai.service.ScenarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class AskController {

    @Autowired
    private ScenarioService scenarioService;

    @PostMapping("/ask")
    public String askAi(@RequestBody AskModel askModel) throws IOException {

        String question = askModel.getQuestion();
        String scenario = askModel.getScenario();

        return scenarioService.loadScenario(scenario);
    }
}
