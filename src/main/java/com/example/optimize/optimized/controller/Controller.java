package com.example.optimize.optimized.controller;

import com.example.optimize.optimized.service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Ajay on 7/28/2018.
 */
@RestController
public class Controller {
    @Autowired
    Service service;

    @RequestMapping(value = "/processType/{type}", method = RequestMethod.GET)
    public ResponseEntity<Void> processType(@PathVariable String type) {
        service.processContract(type);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
