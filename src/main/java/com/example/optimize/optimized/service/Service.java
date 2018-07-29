package com.example.optimize.optimized.service;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Ajay on 7/28/2018.
 */
@org.springframework.stereotype.Service
public class Service {
    private static Map<String, Action> commandMap;

    static {
        commandMap = new HashMap<>();

        commandMap.put("dsl", () -> System.out.println("Processed dsl"));
        commandMap.put("electricity", () -> System.out.println("Process electricity"));
        commandMap.put("apartment_rent", () -> System.out.println("Processed apartment"));
    }

    public void processContract(String type) {

        Action action = () -> System.out.println("Bad request");
        if (commandMap.get(type) != null) {
            commandMap.get(type).performAction();
        } else {
            action.performAction();
        }
    }
}
