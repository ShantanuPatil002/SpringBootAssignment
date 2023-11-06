package com.shantanu.calculator.controller;

import com.shantanu.calculator.models.ResponsePayload;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class GreetingController {

    @GetMapping("/greetapi/v1/hello")
    public ResponseEntity<ResponsePayload> sendGreeting(@RequestParam(value = "name",required = false) Optional<String> name){
        ResponsePayload responsePayload = new ResponsePayload(null,String.format("Hello %s", name.orElse("World!")),null, HttpStatus.OK);
        return new ResponseEntity<>(responsePayload,responsePayload.getHttpStatus());
    }
}
