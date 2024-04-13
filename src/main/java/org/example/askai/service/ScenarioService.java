package org.example.askai.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import org.example.askai.model.Scenario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;

@Service
public class ScenarioService {

    @Autowired
    private ResourceLoader resourceLoader;


    public String loadScenario(String scenarioName) throws IOException {

        String rootPath = "src/main/resources/scenarios/";
        String extension = ".yml";
        String path = rootPath + scenarioName + extension;

        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        mapper.findAndRegisterModules();

        File file = new File(path);

        Scenario scenario = mapper.readValue(file, Scenario.class);

        System.out.println(scenario.getName());
        System.out.println(scenario.getAge());

        return "name " + scenario.getName() + " age " + scenario.getAge();
    }
}
